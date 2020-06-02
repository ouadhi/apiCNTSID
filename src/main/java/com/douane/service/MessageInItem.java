package com.douane.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageInItem {
	private String title;
	private int count_today;
	private int count_all;

}
