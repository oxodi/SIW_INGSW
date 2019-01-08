package persistence;

import java.util.List;

import entita.Cliente;
import persistence.dao.ClienteDao;

public class ClienteDaoJDBC implements ClienteDao {

	@Override
	public void salva(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente cercaPerChiavePrimaria(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> cercaTutti() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiorna(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancella(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPassword(Cliente cliente, String password) {
		// TODO Auto-generated method stub
		
	}

}
