package br.com.hsj.ep119.api.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

/**
 * 
 * Classe utilizada para encapsular as chamadas a API de Logs
 *
 */
public class LogUtil {

	private static final Logger log = getLogger(AppenderTypes.TRACER.getAppender());

	/** formato de escrita: classe mensagem */
	private static final String FORMATO_LOG_SIMPLES = "%s - %s";

	private static final String FORMATO_LOG_ERRO_SIMPLES = "%s - <ERRO> - %s: %s";

	/** formato de escrita: classe -> metodo - OK [TEMPO ms] */
	private static final String FORMATO_LOG_EXECUCAO_OK = "%s -> %s - OK [%d ms]";

	public static final String NULL_TEXT = "<null>";
	
	public static final String ARQUIVO_TIME_EXECUTION = "timeExecution";
	
	/**
	 * Método utilizado para escrever uma mensagem de log em um arquivo específico
	 * 
	 * @param _clazz Classe que está gerando o log
	 * @param _nomeArquivo Nome do arquivo em que a mensagem deverá ser gravada
	 * @param _mensagem Mensagem que severá ser gravada
	 */
	public static <T> void info(final Class<T> _clazz, final String _nomeArquivo, final String _mensagem) {
		if (_nomeArquivo != null) {
			ThreadContext.put("logFileName", _nomeArquivo);
			//[class=%s] %s
			log.info(String.format(FORMATO_LOG_SIMPLES, _clazz.getName(), _mensagem));
			ThreadContext.remove("logFileName");
		}
	}


	/**
	 * Método utilizado para escrever uma mensagem de log em um arquivo específico
	 * 
	 * @param _clazz Classe que está gerando o log
	 * @param _nomeArquivo Nome do arquivo em que a mensagem deverá ser gravada
	 * @param _mensagem Mensagem que severá ser gravada
	 */
	public static <T> void debug(final Class<T> _clazz, final String _nomeArquivo, final String _mensagem) {
		if (_nomeArquivo != null) {
			ThreadContext.put("logFileName", _nomeArquivo);
			// [class=%s] %s
			log.debug(String.format(FORMATO_LOG_SIMPLES, _clazz.getName(), _mensagem));
			ThreadContext.remove("logFileName");
		}
	}

	/**
	 * Método utilizado para escrever uma mensagem de log em um arquivo específico
	 * 
	 * @param _clazz Classe que está gerando o log
	 * @param _nomeArquivo Nome do arquivo em que a mensagem deverá ser gravada
	 * @param _mensagem Mensagem que severá ser gravada
	 */
	public static <T> void trace(final Class<T> _clazz, final String _nomeArquivo, final String _mensagem) {
		if (_nomeArquivo != null) {
			ThreadContext.put("logFileName", _nomeArquivo);
			//[class=%s] %s
			log.trace(String.format(FORMATO_LOG_SIMPLES, _clazz.getName(), _mensagem));
			ThreadContext.remove("logFileName");
		}
	}

	/**
	 * Método utilizado para logar os erros da aplicação
	 * 
	 * @param _clazz Classe que está gerando o log
	 * @param _nomeArquivo Nome do arquivo em que a mensagem deverá ser gravada
	 * @param _mensagem mensagem que deverá ser logada
	 * @param _exception Exceção capturada
	 */
	public static <T> void erro(final Class<T> _clazz, final String _nomeArquivo, final String _mensagem, final Throwable _exception) {
		if (_nomeArquivo != null) {
			ThreadContext.put("logFileName", _nomeArquivo);
			String exceptionDesc = _exception != null ? _exception.toString() : "<NO EXCEPTION>";
			// [class=%s] - <ERRO> - %s: %s
			String mensagem = String.format(FORMATO_LOG_ERRO_SIMPLES, _clazz.getName(), _mensagem, exceptionDesc);
			log.error(mensagem, _exception);
			ThreadContext.remove("logFileName");
		}
	}

	public static Logger getLogger(final String value) {
		return LogManager.getLogger(value);
	}
}
