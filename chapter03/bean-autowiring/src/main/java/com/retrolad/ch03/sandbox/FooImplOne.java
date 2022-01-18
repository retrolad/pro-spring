package com.retrolad.ch03.sandbox;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// Primary annotation indicates that the bean should
// be given preference when there is an ambiguity
// which bean should be injected
@Component
@Primary
public class FooImplOne implements Foo {
}
