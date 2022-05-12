package fr.insa.banqueservice.resources.payload;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DebitRequest {
    private Operation operation;
}
