package pl.oskarpolak.logsys.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class UserDto {
    //@JsonInclude(JsonInclude.Include.NON_NULL) do deserializacji
    @NotNull
    @Size(min = 5, max = 60)
    private String login;
    //@JsonProperty("cospassword") inna nazwa w jsonie (mapowanie)
    @NotNull
    @Size(min = 5, max = 60)
    private String password;
    @NotNull
    @Size(min = 5, max = 60)
    private String firstname;
    @NotNull
    @Size(min = 5, max = 60)
    private String surname;
}
