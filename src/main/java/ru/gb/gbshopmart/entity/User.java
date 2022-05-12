package ru.gb.gbshopmart.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

	private String username;

	private String password;
}
