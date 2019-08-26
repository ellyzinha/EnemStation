package br.ifpe.web.projeto2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import br.ifpe.web.projeto2.Model.Usuario;

public class AutorizadorInterceptor implements HandlerInterceptor {
	private static final boolean CONTROLAR_ACESSO = true;

	private static final String[] RECURSOS_LIVRES = {"Home","/","/logout", "/efetuarLogin", "/acesso-negado","/cad","/addUsuario","/modificar_senha", "/email-enviado","/esquecer_senha","/esquecerSenhaForm","/lista_material/","/loginGmail","/loginGmailG","/loginGmailRequisicao"};

	private static final String PAGINA_ACESSO_NEGADO = "/acesso-negado";
	
	private static final String[] RECURSOS_USUARIO = {"/loginGmail","/cadastroPlano","/salvarPerfil","/material_disciplina","esquecerSenhaForm","/editar_plano","/perfil","/desempenho","/lista_material/","/questoes","/addUsuario","/questao","/questao-achada","/vermais","/listaQuestoes","/salvarResposta","/plano_estudo","/editarPlano","/removerPlano","/formularioPlano/","/planoEstudo","/cadastroPlano","/dados_pessoais"};
	
	private static final String[] RECURSOS_ADMIN = {"/adicionar_materiais","/salvarMaterial"};

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(" >>> INFO:: Interceptor antes da chamada <<< ");
		
		//libera todos arquivos da pasta static
		if(handler instanceof ResourceHttpRequestHandler) {
			return true;
		}

		if (!CONTROLAR_ACESSO) {
			return true;
		}
		
		// Para acessar qualquer pagina dessa aplicação, o usuário precisa estar
		// autenticado
		
		for (String recurso : RECURSOS_LIVRES) {
			if (request.getRequestURL().toString().endsWith(recurso)) {
				return true;
			}
		}
		
		

		if (request.getSession().getAttribute("usuarioLogado") == null) {
			request.getRequestDispatcher(PAGINA_ACESSO_NEGADO).forward(request, response);
			return false;
		} else {
			
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
			
			for (String recurso : RECURSOS_ADMIN) {
				if (request.getRequestURL().toString().contains(recurso) && usuario.getPermissao() == 1) {
					return true;
				}
			}
			
			for (String recurso : RECURSOS_USUARIO) {
				if (request.getRequestURL().toString().contains(recurso) && usuario.getPermissao() == 0) {
					return true;
				}
			}
		
			request.getRequestDispatcher(PAGINA_ACESSO_NEGADO).forward(request, response);
			return false;
		}

	}

}
