package org.zerock.capstonboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionDTO {
    char q_cat;
    String q_dtt;
    String q_content;
    String q_title;
    String u_id;
}
