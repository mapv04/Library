package com.hcl.library.model.bo;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthorBO extends PersonBO{
	private String nacionality;

}
