package com.example.demo.config;

import com.samskivert.mustache.Mustache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MustacheConfig implements WebMvcConfigurer {
    
    @Bean
    public Mustache.Compiler mustacheCompiler(Mustache.TemplateLoader templateLoader) {
        return Mustache.compiler()
                .withLoader(templateLoader)
                .defaultValue("")
                .withFormatter(new Mustache.Formatter() {
                    @Override
                    public String format(Object value) {
                        if (value instanceof Boolean) {
                            return (Boolean) value ? "true" : "false";
                        }
                        return String.valueOf(value);
                    }
                });
    }
}