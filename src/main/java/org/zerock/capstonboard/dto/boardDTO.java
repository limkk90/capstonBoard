package org.zerock.capstonboard.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class boardDTO {
    private char cat_cd;
    private String b_title;
    private String b_content;
    private String b_dtt;
    private String u_id;
    private String join;
}
