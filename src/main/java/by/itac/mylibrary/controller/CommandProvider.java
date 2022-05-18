package by.itac.mylibrary.controller;

import java.util.HashMap;
import java.util.Map;

import by.itac.mylibrary.controller.command.Command;
import by.itac.mylibrary.controller.command.impl.Delete;
import by.itac.mylibrary.controller.command.impl.Save;
import by.itac.mylibrary.controller.command.impl.Update;
import by.itac.mylibrary.controller.command.impl.WrongRequest;

public final class CommandProvider {

	private final Map<CommandName, Command> repository = new HashMap<>();

	CommandProvider() {

		repository.put(CommandName.SAVE, new Save());
		repository.put(CommandName.DELETE, new Delete());
		repository.put(CommandName.UPDATE, new Update());
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());

	}

	public Command getCommand(String name) {
		CommandName commandName = null;
		Command command = null;
		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			// write log
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		return command;
	}

}
