package com.axonactive.exception;

import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;

public class CustomExceptionHandler  extends ExceptionHandlerWrapper {

	private ExceptionHandler wrapped;

	public CustomExceptionHandler(ExceptionHandler wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public ExceptionHandler getWrapped() {
		// TODO Auto-generated method stub
		return wrapped;
	}

	@Override
	public void handle() throws FacesException {
		Iterator iterator = getUnhandledExceptionQueuedEvents().iterator();

		while (iterator.hasNext()) {

			FacesContext fc = FacesContext.getCurrentInstance();

			try {
				

				NavigationHandler navigationHandler = fc.getApplication().getNavigationHandler();

				navigationHandler.handleNavigation(fc, null, "error?faces-redirect=true");

				fc.renderResponse();
			} finally {
				iterator.remove();
			}
		}

		// Let the parent handle the rest
		getWrapped().handle();
	}
}
