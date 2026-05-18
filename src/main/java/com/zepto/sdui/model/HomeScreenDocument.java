package com.zepto.sdui.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import java.util.Map;

@Data
@Document(collection = "screens")
public class HomeScreenDocument {
    @Id
    private String id;
    private String screen;
    private int version;
    private List<Map<String, Object>> components;
}


