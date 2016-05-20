package Teste;

import java.util.List;
import javax.persistence.Query;
import Entity.Usinada;

public class testeUsinadaDao extends testeGenericDao<Usinada> {


	public List<Usinada> listaUsinada() {
		try {
			Query query = null;
			query = createNamedQuery("select c from Usinada as c");
			List<Usinada> usinada = query.getResultList();
			return usinada;
		} catch (IllegalStateException e) {
			e.printStackTrace();
//			throw new Exception(e);
		} catch (Exception e) {
			e.printStackTrace();
//			throw new Exception(e);
		}
		return null;
	}
}