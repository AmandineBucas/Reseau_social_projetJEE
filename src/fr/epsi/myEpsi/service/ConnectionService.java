package fr.epsi.myEpsi.service;

import fr.epsi.myEpsi.beans.User;

public class ConnectionService implements IConnectionService {

	@Override
	public boolean isAuthorized(User user) {
		
		// Retourne la valeur du boolean, si c'est un administrateur ou non
		return user.getAdministrator();
	}

}

