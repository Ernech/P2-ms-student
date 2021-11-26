package com.arquitecturasoftware.msstudent.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class StudentConfig {

    @Value("${arquitectura.software}")
    private String arquitecturaSoftware;

    public String showConfiguration(){
        return String.format("EL valor del apllication yml es: %s",arquitecturaSoftware);
    }
}
