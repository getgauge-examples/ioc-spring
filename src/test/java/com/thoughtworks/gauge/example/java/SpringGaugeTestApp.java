package com.thoughtworks.gauge.example.java;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Component scan finds all components/beans/... below this package.
 */
@Configuration
@ComponentScan
public class SpringGaugeTestApp {
}
