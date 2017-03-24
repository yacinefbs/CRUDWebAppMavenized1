package com.joseph.www.dao;


import java.util.List;

import com.joseph.www.entities.Banques;




public interface IBanque {
	public Banques ajouterBanque(Banques b);
	public Banques getBanqueById(Long idBanque);
	public List<Banques> getAllBanques();
	public Banques modifierBanque(Banques b);
	public void supprimerBanque(Long idBanque);
	public Banques getBanqueByAgence(Long idAgence);
}