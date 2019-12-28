package jackson.example;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

/**
 * author yg
 * description
 * date 2019/12/14
 */
@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true)
@JsonSubTypes({@JsonSubTypes.Type(value = InputPage.class, name = "input0")
        , @JsonSubTypes.Type(value = NumberPage.class, name = "number0")})
public abstract class Page {

    private String type;
    private String name;
    private String uiType;
    private String label;
}
