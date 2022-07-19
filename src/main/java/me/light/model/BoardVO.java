package me.light.model;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO {
	private Long bno; 
	private String title; 
	private String content; 
	private String writer; 
	private LocalDateTime regDate;
	private LocalDateTime updateDate;
}
