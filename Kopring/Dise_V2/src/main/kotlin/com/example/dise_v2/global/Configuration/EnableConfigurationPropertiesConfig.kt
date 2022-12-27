package com.example.dise_v2.global.property

import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration

@ConfigurationPropertiesScan("com.example.dise_v2.global.security")
@Configuration
class EnableConfigurationPropertiesConfig {
}