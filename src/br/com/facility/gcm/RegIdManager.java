package br.com.facility.gcm;

import java.io.IOException;
import java.util.Map;

import br.com.facility.bo.MensagemBO;
import br.com.facility.bo.NegociacaoBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Negociacao;
import br.com.facility.to.Usuario;

public class RegIdManager {
	static final String REG_ID_STORE = "C:\\Users\\Andersson\\git\\ProjetoFacility\\src\\gcmchat.txt";
	private static UsuarioBO uBO = new UsuarioBO(EntityManagerFactorySingleton.getInstance().createEntityManager());	
	private static NegociacaoBO nBO = new NegociacaoBO(EntityManagerFactorySingleton.getInstance().createEntityManager());
	private static MensagemBO mBO = new MensagemBO(EntityManagerFactorySingleton.getInstance().createEntityManager());
	
	public static void writeToFile(String name, String regId) throws IOException {
		Map<String, String> regIdMap = readFromFile();

		if (!regIdMap.containsValue(name)) {
//			regIdMap.put(name, regId);
//			PrintWriter out = new PrintWriter(new BufferedWriter(
//					new FileWriter(REG_ID_STORE, false)));
//			for (Map.Entry<String, String> entry : regIdMap.entrySet()) {
//				out.println(entry.getKey() + "," + entry.getValue());
//			}
//			out.println(name + "," + regId);
//			out.close();
			//teste
			
			Usuario u = uBO.buscarPorUsername(name);
			//nBO.buscarPorNegociacao()
			uBO.cadastrarGCM(u.getId(), regId);
			
			
		}else{
			System.out.println("Não foi possivel salvar a regID");
		}
	}

	public static Map<String, String> readFromFile() {
		Map<String, String> regIdMap = null;
		try {
//			BufferedReader br = new BufferedReader(new FileReader(REG_ID_STORE));
//			String regIdLine = "";
//			regIdMap = new HashMap<String, String>();
//			while ((regIdLine = br.readLine()) != null) {
//				String[] regArr = regIdLine.split(",");
//				regIdMap.put(regArr[0], regArr[1]);
//			}
//			br.close();
			
//			long proto = Long.parseLong(protocol);
//			String api = null;
//			
//			Negociacao n = nBO.buscar(proto);
//			//api = mBO.buscar(1,n);
			
			regIdMap = uBO.listarGCM();
			
		} catch (Exception ioe) {
			System.out.println("erro");
		}
		
		return regIdMap;
	}
}
