package br.ifpe.web.projeto2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import br.ifpe.web.projeto2.Model.Usuario;

public class AutorizadorInterceptor implements HandlerInterceptor {
	private static final boolean CONTROLAR_ACESSO = true;

	private static final String[] RECURSOS_LIVRES = {"/","/logout", "/efetuarLogin", "/acesso-negado","/cad","/addUsuario", "/modificarSenha", "/email-enviado","/esquecer_senha"};

	private static final String PAGINA_ACESSO_NEGADO = "/acesso-negado";
	
	private static final String[] RECURSOS_USUARIO = {"/loginGmail","/material_disciplina","/loginGmail","esquecerSenhaForm","/editar_plano","/perfil"};
	
	private static final String[] RECURSOS_ADMIN = {"/adicionar_materiais","/salvarMaterial"};

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(" >>> INFO:: Interceptor antes da chamada <<< ");

		if (!CONTROLAR_ACESSO) {
			return true;
		}
		
		// Para acessar qualquer pagina dessa aplicação, o usuário precisa estar
		// autenticado
		
		
		for (String recurso : RECURSOS_ADMIN) {
			if (request.getRequestURL().toString().endsWith(recurso)) {
				return true;
			}
		}
		
		
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
				if (request.getRequestURL().toString().endsWith(recurso) && usuario.getPermissao() == 1) {
					return true;
				}else {
					request.getRequestDispatcher(PAGINA_ACESSO_NEGADO).forward(request, response);
					return false;
				}
			}
			
			for (String recurso : RECURSOS_USUARIO) {
				if (request.getRequestURL().toString().endsWith(recurso) && usuario.getPermissao() == 0) {
					return true;
				}else {
					request.getRequestDispatcher(PAGINA_ACESSO_NEGADO).forward(request, response);
					return false;
				}
			}
			
			/*for (String recurso : RECURSOS_USUARIO) {
				if (request.getRequestURL().toString().endsWith(recurso) && usuario.getPermissao() == 0) {
					return true;
				}else {
					return false;
				}
			}*/
			
			return false;
		}

	}

}
