# Auditing 동작 과정
JPA에서의 Auditing은 각 엔티티 별로 누가 언제 접근 했는지 기록하여 감시 체계를 꾸리는 것 이다.



먼저 아래와 같이 Main 메소드에 @EnableJpaAuditing 추가해 줍니다.
```
@EnableJpaAuditing  
@SpringBootApplication  
public class AuthApplication {  

   public static void main(String[] args) {  
      SpringApplication.run(AuthApplication.class, args);  
   }  
}
```

그러면 아래와 같이 @EnableJpaAuditing 은 JpaAuditingRegistrar 를 @Import 하고 있습니다.
```
@Documented  
@Target(ElementType.TYPE)  
@Retention(RetentionPolicy.RUNTIME)  
@Import(JpaAuditingRegistrar.class)  
public @interface EnableJpaAuditing {
  ...
}
```


이제 @EnableJpaAuditing을 통해 auditingHandler를 등록하는 과정을 확인 할 수 있습니다.

**JpaAuditingRegistrar**
```
@Override  
public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {  
  
   Assert.notNull(annotationMetadata, "AnnotationMetadata must not be null");  
   Assert.notNull(registry, "BeanDefinitionRegistry must not be null");  
  
   registerBeanConfigurerAspectIfNecessary(registry);  
   super.registerBeanDefinitions(annotationMetadata, registry);  
   registerInfrastructureBeanWithId(  
         BeanDefinitionBuilder.rootBeanDefinition(AuditingBeanFactoryPostProcessor.class).getRawBeanDefinition(),  
         AuditingBeanFactoryPostProcessor.class.getName(), registry);  
}
```

여기서 EnableJpaAuditing 어노테이션 정보가 들어있는 annotationMetadata를 
super.registerBeanDefinitions(annotationMetadata, registry) 로직을 통해 부모 객체에 있는 메소드를 실행 시켜 넘겨줍니다.


**AuditingBeanDefinitionRegistrarSupport**
```
   @Override  
   public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {  
  
      Assert.notNull(annotationMetadata, "AnnotationMetadata must not be null");  
      Assert.notNull(registry, "BeanDefinitionRegistry must not be null");  
  
      AbstractBeanDefinition ahbd = registerAuditHandlerBeanDefinition(getConfiguration(annotationMetadata), registry);  
      registerAuditListenerBeanDefinition(ahbd, registry);  
   }
}

protected AbstractBeanDefinition registerAuditHandlerBeanDefinition(AuditingConfiguration configuration,  
      BeanDefinitionRegistry registry) {  
  
   Assert.notNull(registry, "BeanDefinitionRegistry must not be null");  
   Assert.notNull(configuration, "AuditingConfiguration must not be null");  
  
   BeanDefinitionBuilder builder = getAuditHandlerBeanDefinitionBuilder(configuration);  
   postProcess(builder, configuration, registry);  
   AbstractBeanDefinition ahbd = builder.getBeanDefinition();  
   registry.registerBeanDefinition(getAuditingHandlerBeanName(), ahbd);  
   return ahbd;  
}
```
그렇게 되면 위의 메소드가 실행 되고 
registerAuditHandlerBeanDefinition(getConfiguration(annotationMetadata), registry)를 통해서 auditingHandler를 빈으로 등록합니다.

이후 registerAuditListenerBeanDefinition(ahbd, registry)로 다시 JpaAuditingRegistrar로 돌아와서 
  
**JpaAuditingRegistrar**
```
@Override  
protected void registerAuditListenerBeanDefinition(BeanDefinition auditingHandlerDefinition,  
      BeanDefinitionRegistry registry) {  
  
   if (!registry.containsBeanDefinition(JPA_MAPPING_CONTEXT_BEAN_NAME)) {  
      registry.registerBeanDefinition(JPA_MAPPING_CONTEXT_BEAN_NAME, //  
            new RootBeanDefinition(JpaMetamodelMappingContextFactoryBean.class));  
   }  
  
   BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(AuditingEntityListener.class);  
   builder.addPropertyValue("auditingHandler",  
         ParsingUtils.getObjectFactoryBeanDefinition(getAuditingHandlerBeanName(), null));  
   registerInfrastructureBeanWithId(builder.getRawBeanDefinition(), AuditingEntityListener.class.getName(), registry);  
}
```
위와 같이 AuditingEntityListener에 auditingHandler를 넣고 빌더 패턴을 통해 AuditingEntityListener도 빈으로 등록합니다.


이제 EntityListeners을 통해 Audit이 동작되어 지는 과정을 확인해 봅시다!
```
@Getter  
@MappedSuperclass  
@EntityListeners(AuditingEntityListener.class)  
public abstract class BaseEntity {  
    @CreatedDate  
    @Column(nullable = false)  
    private Instant createAt;  
  
    @LastModifiedDate  
    private Instant lastModifiedAt;   
}
```
