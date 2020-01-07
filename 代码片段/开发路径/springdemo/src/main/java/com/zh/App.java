package com.zh;

import com.zh.ioc.BraveKnight;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App
{
    public static void main( String[] args )
    {
        new AnnotationConfigApplicationContext(BraveKnight.class);
        System.out.println( "Hello World!" );
    }
}
