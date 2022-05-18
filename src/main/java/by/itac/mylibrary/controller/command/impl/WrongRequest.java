package by.itac.mylibrary.controller.command.impl;

import by.itac.mylibrary.controller.command.Command;

public class WrongRequest implements Command {

	@Override
	public String execute(String request) {

		String response = "Entered request: " + request + ". Request format: command*param1*param2*paramN";

		return response;
	}
}
