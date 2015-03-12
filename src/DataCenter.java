import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class DataCenter {
	
	int nb_rangee;
	int nb_empl;
	int nb_indisp;
	List<Position> indisponibles;
	int nb_groups;
	int nb_servers;
	List<Server> servers;
	List<Rangee> rangees = new LinkedList<Rangee>();
	
	public DataCenter() {
		indisponibles = new LinkedList<Position>();
		servers = new LinkedList<Server>();
	}
	
	void load(String filename) throws IOException {
		BufferedReader data = new BufferedReader(new FileReader(filename));
		String ldata=data.readLine();
		String[] ParsedData=ldata.split(" ");
		nb_rangee=Integer.parseInt(ParsedData[0]);
		nb_empl=Integer.parseInt(ParsedData[1]);
		nb_indisp=Integer.parseInt(ParsedData[2]);
		nb_groups=Integer.parseInt(ParsedData[3]);
		nb_servers=Integer.parseInt(ParsedData[4]);
		
		//Construire les rangées
		for(int i=0; i<nb_rangee; i++){
			Rangee rangee = new Rangee(i);
			rangees.add(rangee);
		}
		
		for (int i = 0 ; i < nb_indisp ; ++i) {
			ldata = data.readLine();
			String[] temp = ldata.split(" ");
			Position pos = new Position(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
			indisponibles.add(pos);
		}
		
		for (int i = 0 ; i < nb_servers ; ++i) {
			ldata = data.readLine();
			String[] temp = ldata.split(" ");
			Server serv = new Server(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
			servers.add(serv);
		}
		
		data.close();
	}
	
	void print() {
		for (int i = 0 ; i < nb_rangee ; ++i) {
			for (int j = 0 ; j < nb_empl ; ++j) {
				System.out.print(".");
			}
			System.out.print("\n");
		}
	}

}
