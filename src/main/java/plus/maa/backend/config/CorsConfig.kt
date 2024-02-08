package plus.maa.backend.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import plus.maa.backend.handler.AccessLimitInterceptHandlerImpl

/**
 * @author AnselYuki
 */
@Configuration
class CorsConfig : WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        // 设置允许跨域的路径
        registry
            .addMapping("/**") // 设置允许跨域请求的域名
            .allowedOriginPatterns("*") // 是否允许cookie
            .allowCredentials(true) // 设置允许的请求方式
            .allowedMethods("GET", "POST", "DELETE", "PUT") // 设置允许的header属性
            .allowedHeaders("*") // 跨域允许时间
            .maxAge(3600)
    }


    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(AccessLimitInterceptHandlerImpl())
    }
}
