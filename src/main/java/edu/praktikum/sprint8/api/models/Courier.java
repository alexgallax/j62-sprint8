package edu.praktikum.sprint8.api.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Courier {
    private String login;
    private String password;
    private String firstName;
}
