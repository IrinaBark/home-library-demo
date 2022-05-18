package by.itac.mylibrary.start;

import java.util.Scanner;

import by.itac.mylibrary.controller.Controller;

import by.itac.mylibrary.service.exception.ServiceException;

public class Main {

	public static void main(String[] args) throws ServiceException {

		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("Please, enter your request! Format of the request: command param1 param2 paramN >");

			String request = sc.nextLine();

			Controller controller = new Controller();

			System.out.println(controller.executeTask(request));
		}

	}

}
