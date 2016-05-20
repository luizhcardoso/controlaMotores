package Teste;

import java.util.List;
import javax.persistence.Query;
import Entity.pontoDeLeitura;

public class testePontoDeLeituraDAO extends testeGenericDao<pontoDeLeitura> {


	public List<pontoDeLeitura> listaPontoDeLeituras() {
		try {
			Query query = null;
			
			query = this.createNamedQuery("select c from pontoDeLeitura as c");
			List<pontoDeLeitura> calculos = query.getResultList();
			
			return calculos;
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