package by.itac.mylibrary.service;

import by.itac.mylibrary.service.exception.ServiceException;

public interface StatusBookServcie {
	void changeToRead(int id) throws ServiceException;
}
