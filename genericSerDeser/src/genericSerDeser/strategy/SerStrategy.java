package genericSerDeser.strategy;

public interface SerStrategy {
	public String   createDPMLFormat(Object obj) throws Exception;
}
