ALTER TABLE tb_disciplina character set UTF8 collate utf8_bin;
ALTER TABLE tb_dificuldade character set UTF8 collate utf8_bin;
ALTER TABLE tb_assunto character set UTF8 collate utf8_bin;
ALTER TABLE tb_questoes character set UTF8 collate utf8_bin;
ALTER TABLE tb_alternativas character set UTF8 collate utf8_bin;

insert into tb_disciplina (id, descricao)
values (1, 'Português');
insert into tb_disciplina (id, descricao)
values (2, 'Matemática');
insert into tb_disciplina (id, descricao)
values (3, 'Biologia');
insert into tb_disciplina (id, descricao)
values (4, 'Física');
insert into tb_disciplina (id, descricao)
values (5, 'Química');
insert into tb_disciplina (id, descricao)
values (6, 'Geografia');
insert into tb_disciplina (id, descricao)
values (7, 'História');
insert into tb_disciplina (id, descricao)
values (8, 'Filosofia');
insert into tb_disciplina (id, descricao)
values (9, 'Sociologia');
insert into tb_disciplina (id, descricao)
values (10, 'Espanhol');
insert into tb_disciplina (id, descricao)
values (11, 'Inglês');
insert into tb_disciplina (id, descricao)
values (12, 'Literatura');

insert into tb_dificuldade (id, descricao)
values (1, 'Fácil');
insert into tb_dificuldade (id, descricao)
values (2, 'Médio');
insert into tb_dificuldade (id, descricao)
values (3, 'Difícil');


insert into tb_assunto (id, descricao, id_disciplina)
values (1, 'Interpretação de texto', 1);
insert into tb_assunto (id, descricao, id_disciplina)
values (2, 'Variação Linguística', 1);
insert into tb_assunto (id, descricao, id_disciplina)
values (3, 'Linguística', 1);
insert into tb_assunto (id, descricao, id_disciplina)
values (4, 'Gramática', 1);
insert into tb_assunto (id, descricao, id_disciplina)
values (5, 'Gêneros textuais', 1);
insert into tb_assunto (id, descricao, id_disciplina)
values (6, 'Logaritmo', 2);
insert into tb_assunto (id, descricao, id_disciplina)
values (7, 'Trigonometria', 2);
insert into tb_assunto (id, descricao, id_disciplina)
values (8, 'Análise combinatória', 2);
insert into tb_assunto (id, descricao, id_disciplina)
values (9, 'Porcentagem', 2);
insert into tb_assunto (id, descricao, id_disciplina)
values (10, 'Progressão Aritmética', 2);
insert into tb_assunto (id, descricao, id_disciplina)
values (11, 'Ecologia', 3);
insert into tb_assunto (id, descricao, id_disciplina)
values (12, 'Genética', 3);
insert into tb_assunto (id, descricao, id_disciplina)
values (13, 'Evolução', 3);
insert into tb_assunto (id, descricao, id_disciplina)
values (14, 'Fisiologia', 3);
insert into tb_assunto (id, descricao, id_disciplina)
values (15, 'Citologia', 3);
insert into tb_assunto (id, descricao, id_disciplina)
values (16, 'Mecânica', 4);
insert into tb_assunto (id, descricao, id_disciplina)
values (17, 'Eletricidade', 4);
insert into tb_assunto (id, descricao, id_disciplina)
values (18, 'Ondulatória', 4);
insert into tb_assunto (id, descricao, id_disciplina)
values (19, 'Termologia', 4);
insert into tb_assunto (id, descricao, id_disciplina)
values (20, 'Óptica', 4);
insert into tb_assunto (id, descricao, id_disciplina)
values (21, 'Química orgânica', 5);
insert into tb_assunto (id, descricao, id_disciplina)
values (22, 'Reações inorgânicas', 5);
insert into tb_assunto (id, descricao, id_disciplina)
values (23, 'Eletroquímica', 5);
insert into tb_assunto (id, descricao, id_disciplina)
values (24, 'Termoquímica', 5);
insert into tb_assunto (id, descricao, id_disciplina)
values (25, 'Radioatividade', 5);
insert into tb_assunto (id, descricao, id_disciplina)
values (26, 'Economia', 6);
insert into tb_assunto (id, descricao, id_disciplina)
values (27, 'Urbanização', 6);
insert into tb_assunto (id, descricao, id_disciplina)
values (28, 'Hidrografia', 6);
insert into tb_assunto (id, descricao, id_disciplina)
values (29, 'Geologia e relevo', 6);
insert into tb_assunto (id, descricao, id_disciplina)
values (30, 'População', 6);
insert into tb_assunto (id, descricao, id_disciplina)
values (31, 'Segundo Reinado', 7);
insert into tb_assunto (id, descricao, id_disciplina)
values (32, 'Era Vargas', 7);
insert into tb_assunto (id, descricao, id_disciplina)
values (33, 'Antiguidade Clássica – Roma', 7);
insert into tb_assunto (id, descricao, id_disciplina)
values (34, 'Brasil', 7);
insert into tb_assunto (id, descricao, id_disciplina)
values (35, 'Regime Militar', 7);
insert into tb_assunto (id, descricao, id_disciplina)
values (36, 'Filosofia Temática', 8);
insert into tb_assunto (id, descricao, id_disciplina)
values (37, 'Filosofia Moderna', 8);
insert into tb_assunto (id, descricao, id_disciplina)
values (38, 'Filosofia Antiga', 8);
insert into tb_assunto (id, descricao, id_disciplina)
values (39, 'Filosofia Contemporânea', 8);
insert into tb_assunto (id, descricao, id_disciplina)
values (40, 'Ética', 8);
insert into tb_assunto (id, descricao, id_disciplina)
values (41, 'Sociologia Temática', 9);
insert into tb_assunto (id, descricao, id_disciplina)
values (42, 'Diversidade Cultural e Estratificação Social', 9);
insert into tb_assunto (id, descricao, id_disciplina)
values (43, 'Teorias Sociológicas', 9);
insert into tb_assunto (id, descricao, id_disciplina)
values (44, 'Poder, Estado e Política', 9);
insert into tb_assunto (id, descricao, id_disciplina)
values (45, 'Movimentos Sociais', 9);
insert into tb_assunto (id, descricao, id_disciplina)
values (46, 'Gramática', 10);
insert into tb_assunto (id, descricao, id_disciplina)
values (47, 'Falsos Cognatos', 10);
insert into tb_assunto (id, descricao, id_disciplina)
values (48, 'Interpretação Textual', 10);
insert into tb_assunto (id, descricao, id_disciplina)
values (49, 'Linguagem Verbal x Linguagem Não-Verbal ', 10);
insert into tb_assunto (id, descricao, id_disciplina)
values (50, 'Vocabulário', 10);
insert into tb_assunto (id, descricao, id_disciplina)
values (51, 'Interpretação Textual', 11);
insert into tb_assunto (id, descricao, id_disciplina)
values (52, 'Simple past', 11);
insert into tb_assunto (id, descricao, id_disciplina)
values (53, 'Countable and Uncountable nouns (Substantivos)', 11);
insert into tb_assunto (id, descricao, id_disciplina)
values (54, 'Pronomes', 11);
insert into tb_assunto (id, descricao, id_disciplina)
values (55, 'Linking words (Conectivos)', 11);
insert into tb_assunto (id, descricao, id_disciplina)
values (56, 'Quinhentismo', 12);
insert into tb_assunto (id, descricao, id_disciplina)
values (57, 'Barroco', 12);
insert into tb_assunto (id, descricao, id_disciplina)
values (58, 'Arcadismo', 12);
insert into tb_assunto (id, descricao, id_disciplina)
values (59, 'Romantismo', 12);
insert into tb_assunto (id, descricao, id_disciplina)
values (60, 'Realismo', 12);

insert into tb_questoes (id, comentario, enunciado, imagem, texto,
id_dificuldade, id_assunto, disciplina_id) values (1,NULL, 'Para se entender o trecho como uma unidade de sentido, é preciso que o leitor reconheça a
ligação entre seus elementos. Nesse texto, a coesão é construída predominantemente pela retomada de um termo por outro e pelo uso da elipse. 
O fragmento do texto em que há coesão por elipse do sujeito é: ', NULL,
'(Enem 2013) Gripado, penso entre espirros em como a palavra gripe nos chegou após uma série de contágios entre línguas. Partiu da Itália em 1743 a
epidemia de gripe que disseminou pela Europa, além do vírus propriamente dito, dois vocábulos virais: o italiano influenza e o francês grippe. 
O primeiro era um termo derivado do latim medieval influentia, que significava “influência dos astros sobre os homens”. O segundo era apenas a forma 
nominal do verbo gripper, isto é, “agarrar”. Supõe-se que fizesse referência ao modo violento como o vírus se apossa do organismo infectado.',1,4,1),
(2, NULL, 'Ao escrever um artigo de opinião, o produtor precisa criar uma base de orientação linguística que permita alcançar os leitores e
convencê-los com relação ao ponto de vista defendido. Diante disso, nesse texto, a escolha das formas verbais em destaque objetiva', NULL,
'(Enem 2013)Novas tecnologias
Atualmente, prevalece na mídia um discurso de exaltação das novas tecnologias, principalmente aquelas ligadas às atividades de telecomunicações. 
Expressões frequentes como “o futuro já chegou”, “maravilhas tecnológicas” e “conexão total com o mundo” “fetichi – zam” novos produtos, 
transformando-os em objetos do desejo, de consumo obrigatório. Por esse motivo carregamos hoje nos bolsos, bolsas e mochilas o “futuro” tão festejado.
Todavia, não podemos reduzir-nos a meras vítimas de um aparelho midiático perverso, ou de um aparelho capitalista controlador. Há perversão, 
certamente, e controle, sem sombra de dúvida. Entretanto, desenvolvemos uma relação simbiótica de dependência mútua com os veículos de comunicação, 
que se estreita a cada imagem compartilhada e a cada dossiê pessoal transformado em objeto público de entretenimento. Não mais como aqueles 
acorrentados na caverna de Platão, somos livres para nos aprisionar, por espontânea vontade, a esta relação sadomasoquista com as estruturas 
midiáticas, na qual tanto controlamos quanto somos controlados.',2,4,1),
(3, NULL, 'Na piada, a quebra de expectativa contribui para produzir o
efeito de humor. Esse efeito ocorre porque um dos
personagens', NULL, '(Enem 2013) Dúvida
Dois compadres viajavam de carro por uma estrada de fazenda quando um bicho cruzou a frente do carro.
Um dos compadres falou:
— Passou um largato ali!
O outro perguntou:
— Lagarto ou largato?
O primeiro respondeu:
— Num sei não, o bicho passou muito rápido.', 3,4,1),
(4, NULL, 'As palavras e as expressões são mediadoras dos sentidos produzidos nos textos. 
Na fala de Hagar, a expressão “é como se” ajuda a conduzir o conteúdo enunciado para o campo da', 
'https://d2q576s0wzfxtl.cloudfront.net/2017/08/08150234/questao109.enem2012.png', '(Enem 2012)', 2, 4,1),
(5, NULL, 'No texto, o autor desenvolve uma reflexão sobre diferentes possibilidades de uso da língua e sobre os sentidos que esses usos podem 
produzir, a exemplo das expressões “voltou de ateu”, “disilimina esse” e “eu não sei a ler”. Com essa reflexão, o autor destaca', NULL, '(Enem 2012) Cabeludinho

Quando a Vó me recebeu nas férias, ela me apresentou aos amigos: Este é meu neto. Ele foi estudar no Rio e voltou de ateu. Ela disse que eu voltei de 
ateu. Aquela preposição deslocada me fantasiava de ateu. Como quem dissesse no Carnaval: aquele menino está fantasiado de palhaço. Minha avó entendia 
de regências verbais. Ela falava de sério. Mas todo-mundo riu. Porque aquela preposição deslocada podia fazer de uma informação um chiste. E fez. 
E mais: eu acho que buscar a beleza nas palavras é uma solenidade de amor. E pode ser instrumento de rir. De outra feita, no meio da pelada um menino 
gritou: Disilimina esse, Cabeludinho. Eu não disiliminei ninguém. Mas aquele verbo novo trouxe um perfume de poesia à nossa quadra. 
Aprendi nessas férias a brincar de palavras mais do que trabalhar com elas. Comecei a não gostar de palavra engavetada. Aquela que não pode mudar de 
lugar. Aprendi a gostar mais das palavras pelo que elas entoam do que pelo que elas informam. Por depois ouvi um vaqueiro a cantar com saudade: 
Ai morena, não me escreve / que eu não sei a ler. Aquele a preposto ao verbo ler, ao meu ouvir, ampliava a solidão do vaqueiro.', 3, 4,1),
(6, NULL, 'Utilizando 0,26 como valor aproximado para a tangente de 15° e duas casas decimais nas operações, descobre-se que a área da base desse prédio ocupa na avenida um espaço', 'http://s2.glbimg.com/wFmzcyoTJ-4YBRhZn5gLT4fJR0M=/0x0:290x389/290x389/s.glbimg.com/po/ek/f/original/2013/11/08/enem-prova-2013-136.png'
,'(Enem 2013) As torres Puerta de Europa são duas torres inclinadas uma contra a outra, construídas numa avenida de Madri, na Espanha. 
A inclinação das torres é de 15° com a vertical e elas têm, cada uma, uma altura de 114 m (a altura é indicada na figura como o segmento AB). 
Estas torres são um bom exemplo de um prisma oblíquo de base quadrada e uma delas pode ser observada na imagem.', 3,7,2),
(7, NULL, 'Suponha que o navegante tenha medido o ângulo α = 30°  e, ao chegar ao ponto B, verificou que o barco havia percorrido a distância AB = 2 000 m.'
, 'http://s2.glbimg.com/GTotnU7Qw8dYHLL9Ua2ynlxC4Rs=/0x0:682x219/620x199/s.glbimg.com/po/ek/f/original/2013/10/09/questao_155_da_prova_do_enem_2011_.png'
,'(Enem 2011) Para determinar a distância de um barco até a praia, um navegante utilizou o seguinte procedimento: a partir de um ponto A, mediu o 
ângulo visual α fazendo mira em um ponto fixo P da praia. Mantendo o barco no mesmo sentido, ele seguiu até um ponto B de modo que fosse possível ver 
o mesmo  possível ver o mesmo ponto P da praia, no entanto sob um ângulo visual 2α. A figura ilustra essa situação:', 3, 7,2),
(8, NULL, 'Qual a altura aproximada em que se encontrava o balão?', 'http://3.bp.blogspot.com/-Rm-PKfy3PVo/TlVASI-RRiI/AAAAAAAAADw/wgm4hIim4PI/s1600/160.jpg', 
'(Enem 2010) Um balão atmosférico, lançado em Bauru (343 quilômetros a Noroeste de São Paulo), na noite do último domingo, caiu nesta segunda-feira 
em Cuiabá Paulista, na região de Presidente Prudente, assustando agricultores da região. O artefato faz parte do programa Projeto Hibiscus, 
desenvolvido por Brasil, França, Argentina, Inglaterra e Itália, para a medição do comportamento da camada de ozônio, e sua descida se deu após o 
cumprimento do tempo previsto de medição.

Na data do acontecido, duas pessoas avistaram o balão. Uma estava a 1,8 km da posição vertical do balão e o avistou sob um ângulo de 60º; a outra 
estava a 5,5 km da posição vertical do balão, alinhada com a primeira, e no mesmo sentido, conforme se vê na figura, e o avistou sob um ângulo de 30º.',2, 7,2),
(9, NULL, 'O cientista deveria concluir que, periodicamente, S atinge o valor de', NULL,
'(Enem 2011) Um satélite de telecomunicações, t minutos após ter atingido sua órbita, está a r quilômetros de distância do centro da Terra. 
Quando r assume seus valores máximo e mínimo, diz-se que o satélite atingiu o apogeu e o perigeu, respectivamente. Suponha que, para esse satélite, 
o valor de r em função de t seja dado por
r(t)=58651+0,15�cos(0,06t)
Um cientista monitora o movimento desse satélite para controlar o seu afastamento do centro da Terra. Para isso, ele precisa calcular a soma dos 
valores de r, no apogeu e no perigeu, representada por S.',1, 7,2),
(10, NULL, 'Então, o ponto Q percorrerá, no eixo x, uma distância dada por ', 'http://s2.glbimg.com/WPL788kcPPZyTQZf-uZ3fqBpdWo=/0x0:620x206/620x206/s.glbimg.com/po/ek/f/original/2014/09/03/enem_2009_174.1.png',
'(Enem 2009) Considere um ponto P em uma circunferência de raio r no plano cartesiano. Seja Q a projeção ortogonal de P sobre o eixo x, 
como mostra a figura, e suponha que o ponto P percorra, no sentido anti-horário, uma distância d ≤ r sobre a circunferência.',3, 7,2),
(11, NULL, 'Desprezando a resistência do ar, qual é a direção e o sentido do vetor força resultante que atua sobre o objeto no ponto mais alto da trajetória?',
'https://d2q576s0wzfxtl.cloudfront.net/2017/12/08152101/Enem2014_2a_aplicacao_48.png', '(Enem PPL 2014) Na Antiguidade, algumas pessoas acreditavam que, no lançamento oblíquo de um objeto, a resultante das forças que atuavam sobre ele 
tinha o mesmo sentido da velocidade em todos os instantes do movimento. Isso não está de acordo com as interpretações científicas atualmente 
utilizadas para explicar esse fenômeno.',3, 25,4),
(12, NULL, 'A partir dos resultados, a situação em que ocorre maior emissão de poluentes é aquela na qual o percurso é feito com o motor',NULL,
'(Enem PPL 2014) Um pesquisador avaliou o efeito da temperatura do motor (em velocidade constante) e da velocidade média de um veículo 
(com temperatura do motor constante) sobre a emissão de monóxido de carbono (CO) em dois tipos de percurso, aclive e declive, com iguais distâncias 
percorridas em linha reta. Os resultados são apresentados nas duas figuras.',1, 25,4),
(13, NULL, 'O piloto consegue apanhar o projétil, pois',NULL, '(Enem PPL 2013) Conta-se que um curioso incidente aconteceu durante a Primeira Guerra Mundial. 
Quando voava a uma altitude de dois mil metros, um piloto francês viu o que acreditava ser uma mosca parada perto de sua face. 
Apanhando-a rapidamente, ficou surpreso ao verificar que se tratava de um projétil alemão.',1, 25,4),
(14, NULL, 'O tempo mínimo, em segundos, que o motorista deve gastar para passar pela lombada eletrônica, cujo limite é de 40 km/h, 
sem receber uma multa, é de',NULL, '(Enem PPL 2013) Antes das lombadas eletrônicas, eram pintadas faixas nas ruas para controle da velocidade dos automóveis.
A velocidade era estimada com o uso de binóculos e cronômetros. O policial utilizava a relação entre a distância percorrida e o tempo gasto, para 
determinar a velocidade de um veículo. Cronometrava-se o tempo que um veículo levava para percorrer a distância entre duas faixas fixas, 
cuja distância era conhecida. A lombada eletrônica é um sistema muito preciso, porque a tecnologia elimina erros do operador. A distância entre os 
sensores é de 2 metros, e o tempo é medido por um circuito eletrônico.',2, 25,4),
(15, NULL, 'Considerando uma velocidade de 72 km/h, qual o módulo da diferença entre as acelerações de frenagem depois e antes da adoção dessa tecnologia?',
NULL, '(Enem PPL 2013) O trem de passageiros da Estrada de Ferro VitóriaMinas (EFVM), que circula diariamente entre a cidade de Cariacica, 
na Grande Vitória, e a capital mineira Belo Horizonte, está utilizando uma nova tecnologia de frenagem eletrônica. Com a tecnologia anterior, 
era preciso iniciar a frenagem cerca de 400 metros antes da estação. Atualmente, essa distância caiu para 250 metros, o que proporciona redução no 
tempo de viagem.',2, 25,4),
(16,NULL, 'Com base no texto, quais são os fatores que influenciam a rapidez das transformações químicas relacionadas aos exemplos 1, 2 e 3, 
respectivamente?', NULL,'(ENEM  2010) Alguns fatores podem alterar a rapidez das reações químicas. A seguir, destacam-se três exemplos no contexto da preparação e da conservação de alimentos:

1. A maioria dos produtos alimentícios se conserva por muito mais tempo quando submetidos à refrigeração. Esse procedimento diminui a rapidez das reações que contribuem para a degradação de certos alimentos.
2. Um procedimento muito comum utilizado em práticas de culinária é o corte dos alimentos para acelerar o seu cozimento, caso não se tenha uma panela de pressão.
3. Na preparação de iogurtes, adicionam-se ao leite bactérias produtoras de enzimas que aceleram as reações envolvendo açúcares e proteínas lácteas.',3,15,3),
(17, NULL, 'Para identificar o corpo, os peritos devem verificar se há
homologia entre o DNA mitocondrial do rapaz e o DNA
mitocondrial do(a)',NULL,'(Enem 2013) Para a identificação de um rapaz vítima de
acidente, fragmentos de tecidos foram retirados e
submetidos à extração de DNA nuclear, para comparação
com o DNA disponível dos possíveis familiares (pai, avô
materno, avó materna, filho e filha). Como o teste com o
DNA nuclear não foi conclusivo, os peritos optaram por
usar também DNA mitocondrial, para dirimir dúvidas.',1,15,3),
(18, NULL, 'Considerando a estratégia metodológica descrita, qual
organela celular poderia ser utilizada para inserção de
transgenes em leveduras?', NULL, '(Enem 2013) A estratégia de obtenção de plantas
transgênicas pela inserção de transgenes em cloroplastos,
em substituição à metodologia clássica de inserção do
transgene no núcleo da célula hospedeira, resultou no
aumento quantitativo da produção de proteínas
recombinantes com diversas finalidades biotecnológicas. O
mesmo tipo de estratégia poderia ser utilizada para produzir
proteínas recombinantes em células de organismos
eucarióticos não fotossintetizantes, como as leveduras, que
são usadas para produção comercial de várias proteínas
recombinantes e que podem ser cultivadas em grandes
fermentadores.',2,15,3),
(19,NULL,'A planta triploide oriunda desse cruzamento apresentará
uma grande dificuldade de gerar gametas viáveis, pois
como a segregação dos cromossomos homólogos na meiose
I é aleatória e independente, espera-se que',NULL,'(Enem cancelado 2009) Quando adquirimos frutas no
comércio, observamos com mais frequência frutas sem ou
com poucas sementes. Essas frutas têm grande apelo
comercial e são preferidas por uma parcela cada vez maior
da população. Em plantas que normalmente são diploides,
isto é, apresentam dois cromossomos de cada par, uma das
maneiras de produzir frutas sem sementes é gerar plantas
com uma ploidia diferente de dois, geralmente triploide.
Uma das técnicas de produção dessas plantas triploides é a
geração de uma planta tetraploide (com 4 conjuntos de
cromossomos), que produz gametas diploides e promove a
reprodução dessa planta com uma planta diploide normal.',2,15,3),
(20, NULL, 'De acordo com as informações contidas no texto e nas figuras, o uso da iontoforese', 
'https://d2q576s0wzfxtl.cloudfront.net/2017/08/08150404/questao22_enem2009.png' , 
'(Enem 2009) Um medicamento, após ser ingerido,
atinge a corrente sanguínea e espalha-se pelo organismo,
mas, como suas moléculas “não sabem” onde é que está o
problema, podem atuar em locais diferentes do local “alvo”
e desencadear efeitos além daqueles desejados. Não seria
perfeito se as moléculas dos medicamentos soubessem
exatamente onde está o problema e fossem apenas até
aquele local exercer sua ação? A técnica conhecida como
iontoforese, indolor e não invasiva, promete isso. Como
mostram as figuras, essa nova técnica baseia-se na
aplicação de uma corrente elétrica de baixa intensidade
sobre a pele do paciente, permitindo que fármacos
permeiem membranas biológicas e alcancem a corrente
sanguínea, sem passar pelo estômago. Muitos pacientes
relatam apenas um formigamento no local de aplicação. O
objetivo da corrente elétrica é formar poros que permitam a
passagem do fármaco de interesse. A corrente elétrica é
distribuída por eletrodos, positivo e negativo, por meio de
uma solução aplicada sobre a pele. Se a molécula do
medicamento tiver carga elétrica positiva ou negativa, ao
entrar em contato com o eletrodo de carga de mesmo sinal,
ela será repelida e forçada a entrar na pele (eletrorrepulsão -
A). Se for neutra, a molécula será forçada a entrar na pele
juntamente com o fluxo de solvente fisiológico que se
forma entre os eletrodos (eletrosmose - B).', 3,15,3),
(21, NULL, 'Uma vacina eficiente contra o HIV deveria', NULL, 
'(Enem 2009) Estima-se que haja atualmente no mundo
40 milhões de pessoas infectadas pelo HIV (o vírus que
causa a AIDS), sendo que as taxas de novas infecções
continuam crescendo, principalmente na África, Ásia e
Rússia. Nesse cenário de pandemia, uma vacina contra o
HIV teria imenso impacto, pois salvaria milhões de vidas.
Certamente seria um marco na história planetária e também
uma esperança para as populações carentes de tratamento
antiviral e de acompanhamento médico.',2,15,3),
(22, NULL, 'Em que parte do corpo do NanoKid existe carbono
quaternário? ','http://s2.glbimg.com/cNx4aNE_ZqW3kgQvZZMHD0J5-Qo=/0x0:300x423/300x423/s.glbimg.com/po/ek/f/original/2013/11/06/enem-2013-2_1.png', 
'(Enem 2013) As moléculas de nanoputians lembram
figuras humanas e foram criadas para estimular o interesse
de jovens na compreensão da linguagem expressa em
fórmulas estruturais, muito usadas em química orgânica.
Um exemplo é o NanoKid, representado na figura:',3,21,5),
(23, NULL, 'A camada central de eletrólito polimérico é importante porque',
'https://d2q576s0wzfxtl.cloudfront.net/2017/08/08145626/dsaf.png',' (Enem 2013) Músculos artificiais são dispositivos feitos
com plásticos inteligentes que respondem a uma corrente
elétrica com um movimento mecânico. A oxidação e
redução de um polímero condutor criam cargas positivas
e/ou negativas no material, que são compensadas com a inserção ou expulsão de cátions ou ânions. Por exemplo, na
figura os filmes escuros são de polipirrol e o filme branco é
de um eletrólito polimérico contendo um sal inorgânico.
Quando o polipirrol sofre oxidação, há a inserção de ânions
para compensar a carga positiva no polímero e o filme se
expande. Na outra face do dispositivo o filme de polipirrol
sofre redução, expulsando ânions, e o filme se contrai. Pela
montagem, em sanduíche, o sistema todo se movimenta de
forma harmônica, conforme mostrado na figura.',2,21,5),
(24, NULL, 'Com base nas informações do texto, uma alternativa para a
obtenção de etilenoglicol a partir do PET é a ','https://d2q576s0wzfxtl.cloudfront.net/2017/08/08145624/dsdasfdsa.png',
'(Enem 2013) O uso de embalagens plásticas
descartáveis vem crescendo em todo o mundo, juntamente
com o problema ambiental gerado por seu descarte
inapropriado. O politereftalato de etileno (PET), cuja
estrutura é mostrada, tem sido muito utilizado na indústria
de refrigerantes e pode ser reciclado e reutilizado. Uma das
opções possíveis envolve a produção de matérias-primas,
como o etilenoglicol (1,2-etanodiol), a partir de objetos
compostos de PET pós-consumo',2,21,5),
(25, NULL, 'Essa intervenção produz resultados positivos para o
ambiente porque', NULL ,'(Enem 2012) Em uma planície, ocorreu um acidente
ambiental em decorrência do derramamento de grande
quantidade de um hidrocarboneto que se apresenta na forma
pastosa à temperatura ambiente. Um químico ambiental
utilizou uma quantidade apropriada de uma solução de
para-dodecil-benzenossulfonato de sódio, um agente
tensoativo sintético, para diminuir os impactos desse
acidente',3,21,5),
(26, NULL, 'A preocupação com as possíveis ameaças à camada de
ozônio (O3) baseia-se na sua principal função: proteger a
matéria viva na Terra dos efeitos prejudiciais dos raios
solares ultravioleta. A absorção da radiação ultravioleta
pelo ozônio estratosférico é intensa o suficiente para eliminar 
boa parte da fração de ultravioleta que é prejudicial à vida. A finalidade da utilização dos gases isobutano, butano e propano neste aerossol é',
'https://sites.google.com/site/blogprofwarles/img1_ENEM_CIENCIAS_2012_1%C2%AAAp.png',
'(Enem 2012) O rótulo de um desodorante aerossol
informa ao consumidor que o produto possui em sua
composição os gases isobutano, butano e propano, dentre
outras substâncias. Além dessa informação, o rótulo traz,
ainda, a inscrição “Não tem CFC”. As reações a seguir, que
ocorrem na estratosfera, justificam a não utilização de CFC
(clorofluorcarbono ou Freon) nesse desodorante:',1,21,5),
(27, NULL,'Na imagem, visualizam-se um método de cultivo e as transformações provocadas no espaço geográfico. O objetivo imediato da técnica agrícola utilizada é',
'http://s2.glbimg.com/2rhi8LYaObS2-MUGn2erQ5ExZzg=/0x0:610x403/611x404/s.glbimg.com/po/ek/f/original/2013/11/05/enem-2013-7.png',
'(Enem 2013)',2,26,6),
(28, NULL ,'Na canção, ressalta-se a coexistência, no contexto
internacional atual, das seguintes situações: ', NULL ,' (Enem 2013) Disneylândia
Multinacionais japonesas instalam empresas em HongKong
E produzem com matéria-prima brasileira
Para competir no mercado americano
[...]
Pilhas americanas alimentam eletrodomésticos ingleses na
Nova Guiné
Gasolina árabe alimenta automóveis americanos na África
do Sul
[...]
Crianças iraquianas fugidas da guerra
Não obtêm visto no consulado americano do Egito
Para entrarem na Disneylândia',3,26,6),
(29, NULL, 'Considerando o tipo de relação entre ser humano e condição climática apresentado no texto, uma sociedade torna-se mais vulnerável quando',
NULL,' (Enem 2012) A interface clima/sociedade pode ser
considerada em termos de ajustamento à extensão e aos
modos como as sociedades funcionam em uma relação
harmônica com seu clima. O homem e suas sociedades são
vulneráveis às variações climáticas. A vulnerabilidade é a
medida pela qual uma sociedade é suscetível de sofrer por causas climáticas.',1,26,6),
(30, NULL, 'Com base no texto, uma característica socioespacial e um
consequente desdobramento que marcou o processo de
ocupação do espaço rural na África subsaariana foram:',NULL, '(Enem 2012) A singularidade da questão da terra na
África Colonial é a expropriação por parte do colonizador e
as desigualdades raciais no acesso à terra. Após a
independência, as populações de colonos brancos tenderam
a diminuir, apesar de a proporção de terra em posse da
minoria branca não ter diminuído proporcionalmente.',1,26,6),
(31, NULL, 'De acordo com as características desse país, a matriz energética de menor impacto e risco ambientais é a baseada na energia', 
NULL, ' (Enem 2012) Suponha que você seja um consultor e foi
contratado para assessorar a implantação de uma matriz
energética em um pequeno país com as seguintes
características: região plana, chuvosa e com ventos constantes, dispondo de poucos recursos hídricos e sem
reservatórios de combustíveis fósseis.', 3,26,6),
(32, NULL, 'Um impacto ambiental da tecnologia mais empregada pelo
setor de transporte e uma medida para promover a redução
do seu uso, estão indicados, respectivamente, em:', NULL, ' (Enem 2012) A maior parte dos veículos de transporte
atualmente é movida por motores a combustão que utilizam
derivados de petróleo. Por causa disso, esse setor é o maior
consumidor de petróleo do mundo, com altas taxas de
crescimento ao longo do tempo. Enquanto outros setores
têm obtido bons resultados na redução do consumo, os
transportes tendem a concentrar ainda mais o uso de
derivados do óleo',1,26,6),
(33,NULL, 'Originária dos tempos coloniais, a festa da Coroação
do Rei do Congo evidencia um processo de ', NULL ,'(Enem 2013) Seguiam-se vinte criados
custosamente vestidos e montados em soberbos
cavalos; depois destes, marchava o Embaixador do
Rei do Congo magnificamente ornado de seda azul
para anunciar ao Senado que a vinda do Rei estava
destinada para o dia dezesseis. Em resposta obteve
repetidas vivas do povo que concorreu alegre e
admirado de tanta grandeza. ',1,34,7),
(34,NULL, 'A carta de Pero Vaz de Caminha permite entender o
projeto colonizador para a nova terra. Nesse trecho, o
relato enfatiza o seguinte objetivo: ', NULL ,' (Enem 2013) De ponta a ponta, é tudo praiapalma, muito chã e muito formosa. Pelo sertão nos
pareceu, vista do mar, muito grande, porque, a
estender olhos, não podíamos ver senão terra com
arvoredos, que nos parecia muito longa. Nela, até
agora, não pudemos saber que haja ouro, nem prata,
nem coisa alguma de metal ou ferro; nem lho vimos.
Porém a terra em si é de muito bons ares [...]. Porém
o melhor fruto que dela se pode tirar me parece que
será salvar esta gente.',1,34,7),
(35, NULL, 'No texto, Joaquim Nabuco defende um projeto político sobre como deveria ocorrer o fim da escravidão no Brasil, no qual',
NULL,'(Enem 2013) A escravidão não há de ser
suprimida no Brasil por uma guerra servil, muito
menos por insurreições ou atentados locais. Não
deve sê-lo, tampouco, por uma guerra civil, como o foi
nos Estados Unidos. Ela poderia desaparecer, talvez,
depois de uma revolução, como aconteceu na
França, sendo essa revolução obra exclusiva da
população livre. É no Parlamento e não em fazendas
ou quilombos do interior, nem nas ruas e praças das cidades, que se há de ganhar, ou perder, a causa da
liberdade',3,34,7),
(36,NULL, 'O fragmento do discurso dirigido ao parlamentar do
Império refere-se às mudanças então em curso no
campo brasileiro, que confrontam o Estado e a elite
agrária em torno do objetivo de', NULL ,'(Enem 2013) Ninguém desconhece a necessidade
que todos os fazendeiros têm de aumentar o número
de seus trabalhadores. E como até há pouco supriamse os fazendeiros dos braços necessários? As
fazendas eram alimentadas pela aquisição de
escravos, sem o menor auxílio pecuniário do governo.
Ora, se os fazendeiros se supriam de braços à sua
custa, e se é possível obtê-los ainda, posto que de
outra qualidade, por que motivo não hão de procurar
alcançá-los pela mesma maneira, isto é, à sua custa?',3,34,7),
(37,NULL, 'Na imagem, da década de 1930, há uma crítica à
conquista de um direito pelas mulheres, relacionado
com a ','http://s2.glbimg.com/O_28KOt1s-Cs3CGvodspLjs7Nd4=/0x0:524x544/524x544/s.glbimg.com/po/ek/f/original/2013/11/05/enem-2013-4.png',
' (Enem 2013) ',2,34,7),
(38, NULL, 'A imagem foi publicada no jornal Correio da Manhã,
no dia de Finados de 1965. Sua relação com os
direitos políticos existentes no período revela a ',
'https://d2q576s0wzfxtl.cloudfront.net/2017/08/08145633/quest%C3%A3o20.enem2013.png', '(Enem 2013)',3,34,7),
(39, NULL, 'No mito Édipo Rei, são dignos de destaque os temas do destino e do determinismo. Ambos são características do mito grego e abordam a relação entre 
liberdade humana e providência divina. A expressão filosófica que toma como pressuposta a tese do determinismo é:', NULL ,'(Enem 2012) Quando Édipo nasceu, seus pais, 
Laio e Jocasta, os reis de Tebas, foram informados de uma profecia na qual o filho mataria o pai e se 
casaria com a mãe. Para evitá-la, ordenaram a um criado que matasse o menino. Porém, penalizado com a sorte de Édipo, ele o entregou a um casal de 
camponeses que morava longe de Tebas para que o criasse. Édipo soube da profecia quando se tornou adulto. Saiu então da casa de seus pais para evitar a 
tragédia. Eis que, perambulando pelos caminhos da Grécia, encontrou-se com Laio e seu séquito, que, insolentemente, ordenou que saísse da estrada. 
Édipo reagiu e matou todos os integrantes do grupo, sem saber que entre eles estava seu verdadeiro pai. Continuou a viagem até chegar a Tebas, dominada 
por uma Esfinge. Ele decifrou o enigma da Esfinge, tornou-se rei de Tebas e casou-se com a rainha, Jocasta, a mãe que desconhecia. ',1,38,8),
(40, NULL, 'A partir do texto, é possível perceber a crítica maquiaveliana à filosofia política de Platão, pois há nesta a', NULL ,
'(Enem 2013) Mas, sendo minha intenção escrever algo de útil para quem por tal se interesse, pareceu-me mais conveniente ir em busca da 
verdade extraída dos fatos e não à imaginação dos mesmos, pois muitos conceberam repúblicas e principados jamais vistos ou conhecidos como tendo 
realmente existido',2,38,8),
(41, NULL, 'Segundo Aristóteles, pode-se reconhecer uma ação justa quando ela observa o', NULL,
'(Enem 2013) O termo injusto se aplica tanto às pessoas que infringem a lei quanto às pessoas ambiciosas (no sentido de quererem mais do que 
aquilo a que têm direito) e iníquas, de tal forma que as cumpridoras da lei e as pessoas corretas serão justas. O justo, então, é aquilo conforme à lei e 
o injusto é o ilegal e iníquo.',3,38,8),
(42, NULL, 'O conceito de deliberação tratado por Aristóteles é importante para entender a dimensão da responsabilidade humana. 
A partir do texto, considera-se que é possível ao homem deliberar sobre', NULL,'(Enem 2012) Quanto à deliberação, deliberam as pessoas sobre tudo? 
São todas as coisas objetos de possíveis deliberações? Ou será a deliberação impossível no que tange a algumas coisas? Ninguém delibera sobre coisas eternas e imutáveis, tais como a ordem do universo; tampouco sobre coisas 
mutáveis como os fenômenos dos solstícios e o nascer do sol, pois nenhuma delas pode ser produzida por nossa ação.',1,38,8),
(43, NULL, 'Platão e Aristóteles marcaram profundamente a formação do pensamento Ocidental. No texto, é ressaltado importante aspecto filosófico de ambos 
os autores que, em linhas gerais, refere-se à',NULL,'(Enem 2012) Pode-se viver sem ciência, pode-se adotar crenças sem querer justificá-las 
racionalmente, pode-se desprezar as evidências empíricas. No entanto, depois de Platão e Aristóteles, nenhum homem honesto pode ignorar que uma outra 
atitude intelectual foi experimentada, a de adotar crenças com base em razões e evidências e questionar tudo o mais a fim de descobrir seu sentido último.',
1,38,8),
(44, NULL, 'Em Aristóteles, o conceito de virtude ética expressa a',NULL,
'(Enem 2014) Ao falar do caráter de um homem não dizemos que ele é sábio ou que possui entendimento, mas que é calmo ou temperante. No entanto, louvamos também o 
sábio, referindo-se ao hábito; e aos hábitos dignos de louvor chamamos virtude.',3,38,8),
(45, NULL, 'No contexto descrito, a lei citada pode alterar a situação da mulher ao proporcionar sua',NULL,
'(Enem 2018) A elaboração da Lei n. 11.340/06 (Lei Maria da Penha) partiu, em grande medida, de uma perspectiva crítica aos resultados obtidos pela criação dos 
Juizados Especiais Criminais direcionada à banalização do conflito de gênero, observada na prática corriqueira da aplicação de medidas alternativas 
correspondentes ao pagamento de cestas básicas pelos acusados.',2,38,8);




insert into tb_alternativas (id, descricao, resposta, id_questoes) values
(1, '“[...] a palavra gripe nos chegou após uma série de contágios entre línguas.”',0,1),
(2, '“Partiu da Itália em 1743 a epidemia de gripe [...]”.',0,1),
(3, '“O primeiro era um termo derivado do latim medieval influentia, que significava ‘influência dos astros sobre os homens"',0,1),
(4, '“O segundo era apenas a forma nominal do verbo gripper [...]”.',0,1),
(5, '“Supõe-se que fizesse referência ao modo violento como o vírus se apossa do organismo infectado.”',1,1),
(6, 'criar relação de subordinação entre leitor e autor, já que ambos usam as novas tecnologias.',0,2),
(7, 'enfatizar a probabilidade de que toda população brasileira esteja aprisionada às novas tecnologias.',0,2),
(8, 'indicar, de forma clara, o ponto de vista de que hoje as pessoas são controladas pelas novas tecnologias.',0,2),
(9, 'tornar o leitor copartícipe do ponto de vista de que ele manipula as novas tecnologias e por elas é manipulado.',1,2),
(10, 'demonstrar ao leitor sua parcela de responsabilidade por deixar que as novas tecnologias controlem as pessoas.',0,2),
(11, 'reconhece a espécie do animal avistado.',0,3),
(12, 'tem dúvida sobre a pronúncia do nome do réptil.',0,3),
(13, 'desconsidera o conteúdo linguístico da pergunta.',1,3),
(14, 'constata o fato de um bicho cruzar a frente do carro.',0,3),
(15, 'apresenta duas possibilidades de sentido para a mesma
palavra.',0,3),
(16, 'conformidade, pois as condições meteorológicas evidenciam um acontecimento ruim.',0,4),
(17, 'reflexibilidade, pois o personagem se refere aos tubarões usando um pronome reflexivo.',0,4),
(18, 'condicionalidade, pois a atenção dos personagens é a condição necessária para a sua sobrevivência.',0,4),
(19, 'possibilidade, pois a proximidade dos tubarões leva à suposição do perigo iminente para os homens.',1,4),
(20, 'impessoalidade, pois o personagem usa a terceira pessoa para expressar o distanciamento dos fatos.',0,4),
(21, 'os desvios linguísticos cometidos pelos personagens do texto.',0,5),
(22, 'a importância de certos fenômenos gramaticais para o conhecimento da língua portuguesa.',0,5),
(23, 'a distinção clara entre a norma culta e as outras variedades linguísticas.',0,5),
(24, 'o relato fiel de episódios vividos por Cabeludinho durante as suas férias.',0,5),
(25, 'a valorização da dimensão lúdica e poética presente nos usos coloquiais da linguagem.',1,5),
(26, 'menor que 100 m2.',0,6),
(27, 'entre 100 m2 e 300 m2.',0,6),
(28, 'entre 300 m2 e 500 m2.',0,6),
(29, 'entre 500 m2 e 700 m2.',0,6),
(30, 'maior que 700 m2.',1,6),
(31, '1 000 m.',0,7),
(32, '1 000 3v3vm.',1,7),
(33, '2 000 33--v33--v m.',0,7),
(34, '2 000 m.',0,7),
(35, '2 000 3v3v m.',0,7),
(36, ' 1,8 km',0,8),
(37, '1,9 km',0,8),
(38, '3,1 km',1,8),
(39, '3,7 km',0,8),
(40, '5,5 km',0,8),
(41, '12765 km.',0,9),
(42, '12000 km.',1,9),
(43, '11730 km.',0,9),
(44, '10965 km.',0,9),
(45, '5865 km.',0,9),
(46, 'r( 1 - sen d/r ).',0,10),
(47, 'r( 1 - cos d/r ).',1,10),
(48, 'r( 1 - tag d/r ).',0,10),
(49, 'rsen (r/d).',0,10),
(50, 'rcos (r/d).',0,10),
(51, 'Indefinido, pois ele é nulo, assim como a velocidade vertical nesse ponto.',0,11),
(52, 'Vertical para baixo, pois somente o peso está presente durante o movimento.',1,11),
(53, 'Horizontal no sentido do movimento, pois devido a inêrcia o objeto mantém seu movimento.',0,11),
(54, 'Inclinado na direção do lançamento, pois a força inicial que atua sobre o objeto é constante.',0,11),
(55, 'Inclinado para baixo e no sentido do movimento, pois aponta para o ponto onde o objeto cairá.',0,11),
(56, 'aquecido, em menores velocidades médias e em pista em declive.',0,12),
(57, 'aquecido, em maiores velocidades médias e em pista em aclive.',0,12),
(58, 'frio, em menores velocidades médias e em pista em declive.',0,12),
(59, 'frio, em menores velocidades médias e em pista em aclive.',1,12),
(60, 'frio, em maiores velocidades médias e em pista em aclive.',0,12),
(61, 'ele foi disparado em direção ao avião francês, freado pelo ar e parou justamente na frente do piloto.',0,13),
(62, 'o avião se movia no mesmo sentido que o dele, com velocidade visivelmente superior.',0,13),
(63, 'ele foi disparado para cima com velocidade constante, no instante em que o avião francês passou.',0,13),
(64, 'o avião se movia no sentido oposto ao dele, com velocidade de mesmo valor.',0,13),
(65, 'o avião se movia no mesmo sentido que o dele, com velocidade de mesmo valor.',1,13),
(66, '0,05.',0,14),
(67, '11,1.',0,14),
(68, '0,18.',1,14),
(69, '22,2.',0,14),
(70, '0,50.',0,14),
(71, '0,08 m/s2',0,15),
(72, '0,30 m/s2',1,15),
(73, '1,10 m/s2',1,15),
(74, '1,60 m/s2',1,15),
(75, '3,90 m/s2',1,15),
(76, 'Temperatura, superfície de contato e concentração',0,16),
(77, 'Concentração, superfície de contato e catalisadores',0,16),
(78, 'Temperatura, superfície de contato e catalisadores.',1,16),
(79, 'Superfície de contato, temperatura e concentração.',0,16),
(80, 'Temperatura, concentração e catalisadores.',0,16),
(81, 'pai.',0,17),
(82, 'filho.',0,17),
(83, 'filha.',0,17),
(84, 'avó materna.',1,17),
(85, 'avô materno.',0,17),
(86, 'Lisossomo.',0,18),
(87, 'Mitocôndria.',1,18),
(88, 'Peroxissomo.',0,18),
(89, 'Complexo golgiense.',0,18),
(90, 'Retículo endoplasmático.',0,18),
(91, 'os gametas gerados sejam diploides.',0,19),
(92, 'as cromátides irmãs sejam separadas ao final desse evento.',0,19),
(93, 'o número de cromossomos encontrados no gameta seja 23.',0,19),
(94, 'um cromossomo de cada par seja direcionado para uma célula filha.',0,19),
(95, 'um gameta raramente terá o número correto de cromossomos da espécie.',1,19),
(96, 'provoca ferimento na pele do paciente ao serem introduzidos os eletrodos, rompendo o epitélio.',0,20),
(97, 'aumenta o risco de estresse nos pacientes, causado pela aplicação da corrente elétrica.',0,20),
(98, 'inibe o mecanismo de ação dos medicamentos no tecido-alvo, pois estes passam a entrar por meio da pele.',0,20),
(99, 'diminui o efeito colateral dos medicamentos, se comparados com aqueles em que a ingestão se faz por via oral.',1,20),
(100, 'deve ser eficaz para medicamentos constituídos de moléculas polares e ineficaz, se essas forem apolares.',0,20),
(101, 'induzir a imunidade, para proteger o organismo da contaminação viral.',1,21),
(102, 'ser capaz de alterar o genoma do organismo portador, induzindo a síntese de enzimas protetoras.',0,21),
(103, 'produzir antígenos capazes de se ligarem ao vírus, impedindo que este entre nas células do organismo humano.',0,21),
(104, 'ser amplamente aplicada em animais, visto que esses são os principais transmissores do vírus para os seres humanos.',0,21),
(105, 'estimular a imunidade, minimizando a transmissão do vírus por gotículas de saliva.',0,21),
(106, 'Mãos.',1,22),
(107, 'Cabeça.',0,22),
(108, 'Tórax.',0,22),
(109, 'Abdômen.',0,22),
(110, 'Pés.',0,22),
(111, 'absorve a irradiação de partículas carregadas, emitidas pelo aquecimento elétrico dos filmes de polipirrol.',0,23),
(112, 'permite a difusão dos íons promovida pela aplicação de diferença de potencial, fechando o circuito elétrico..',1,23),
(113, 'mantém um gradiente térmico no material para promover a dilatação/contração térmica de cada filme de polipirrol.',0,23),
(114, 'permite a condução de elétrons livres, promovida pela aplicação de diferença de potencial, gerando corrente elétrica.',0,23),
(115, 'promove a polarização das moléculas poliméricas, o que resulta no movimento gerado pela aplicação de diferença de potencial.',0,23),
(116, 'solubilização dos objetos.',0,24),
(117, 'combustão dos objetos.',0,24),
(118, 'trituração dos objetos.',0,24),
(119, 'hidrólise dos objetos.',1,24),
(120, 'fusão dos objetos.',0,24),
(121, 'promove uma reação de substituição no hidrocarboneto, tornando-o menos letal ao ambiente.',0,25),
(122, 'a hidrólise do para-dodecil-benzenossulfonato de sódio produz energia térmica suficiente para vaporizar o hidrocarboneto.',0,25),
(123, 'a mistura desses reagentes provoca a combustão do hidrocarboneto, o que diminui a quantidade dessa substância na natureza.',0,25),
(124, 'a solução de para-dodecil-benzenossulfonato possibilita a solubilização do hidrocarboneto.',1,25),
(125, 'o reagente adicionado provoca uma solidificação do hidrocarboneto, o que facilita sua retirada do ambiente.',0,25),
(126, 'substituir o CFC, pois não reagem com o ozônio, servindo como gases propelentes em aerossóis.',1,26),
(127, 'servir como propelentes, pois, como são muito reativos, capturam o Freon existente livre na atmosfera, impedindo a destruição do ozônio.',0,26),
(128, 'reagir com o ar, pois se decompõem espontaneamente em dióxido de carbono (CO₂) e água (H₂O), que não atacam o ozônio.',0,26),
(129, 'impedir a destruição do ozônio pelo CFC, pois os hidrocarbonetos gasosos reagem com a radiação UV, liberando hidrogênio (H₂), que reage com o oxigênio do ar (O₂), formando água (H₂O).',0,26),
(130, 'destruir o CFC, pois reagem com a radiação UV, liberando carbono (C), que reage com o oxigênio do ar (O₂), formando dióxido de carbono (CO₂), que é inofensivo para a camada de ozônio.',0,26),
(131, 'controlar a erosão laminar.',1,27),
(132, 'preservar as nascentes fluviais.',0,27),
(133, 'diminuir a contaminação química.',0,27),
(134, 'incentivar a produção transgênica.',0,27),
(135, 'implantar a mecanização intensiva.',0,27),
(136, 'Acirramento do controle alfandegário e estímulo ao capital especulativo.',0,28),
(137, 'Ampliação das trocas econômicas e seletividade dos fluxos populacionais.',1,28),
(138, 'Intensificação do controle informacional e adoção de barreiras fitossanitárias.',0,28),
(139, 'Aumento da circulação mercantil e desregulamentação do sistema financeiro.',0,28),
(140, 'Expansão do protecionismo comercial e descaracterização de identidades nacionais.',0,28),
(141, 'concentra suas atividades no setor primário.',1,29),
(142, 'apresenta estoques elevados de alimentos.',0,29),
(143, 'possui um sistema de transportes articulado.',0,29),
(144, 'diversifica a matriz de geração de energia.',0,29),
(145, 'introduz tecnologias à produção agrícola.',0,29),
(146, 'Exploração do campesinato pela elite proprietária — Domínio das instituições fundiárias pelo poder público. ',0,30),
(147, 'Adoção de práticas discriminatórias de acesso à terra – Controle do uso especulativo da propriedade fundiária.',0,30),
(148, 'Desorganização da economia rural de subsistência – Crescimento do consumo interno de alimentos pelas famílias camponesas.Desorganização da economia rural de subsistência – Crescimento do consumo interno de alimentos pelas famílias camponesas.',0,30),
(149, 'Crescimento dos assentamentos rurais com mão de obra familiar – Avanço crescente das áreas rurais sobre as regiões urbanas.',0,30),
(150, 'Concentração das áreas cultiváveis no setor agroexportador – Aumento da ocupação da população pobre em territórios agrícolas marginais.',1,30),
(151, 'dos biocombustíveis, pois tem menor impacto ambiental e maior disponibilidade.',0,31),
(152, 'solar, pelo seu baixo custo e pelas características do país favoráveis à sua implantação.',0,31),
(153, 'nuclear, por ter menor risco ambiental e ser adequada a locais com menor extensão territorial.',0,31),
(154, 'hidráulica, devido ao relevo, à extensão territorial do país e aos recursos naturais disponíveis.',0,31),
(155, 'eólica, pelas características do país e por não gerar gases do efeito estufa nem resíduos de operação.',1,31),
(156, 'Aumento da poluição sonora — construção de barreiras acústicas.',0,32),
(157, 'Incidência da chuva ácida – estatização da indústria automobilística.',0,32),
(158, 'Derretimento das calotas polares – incentivo aos transportes de massa.',1,32),
(159, 'Propagação de doenças respiratórias – distribuição de medicamentos gratuitos.',0,32), 
(160, 'Elevação das temperaturas médias – criminalização da emissão de gás carbônico.',0,32),
(161, 'exclusão social.',0,33),
(162, 'imposição religiosa.',0,33),
(163, 'acomodação política.',0,33),
(164, 'supressão simbólica.',0,33),
(165, 'ressignificação cultural.',1,33),
(166, 'Valorizar a catequese a ser realizada sobre os povos nativos.',1,34),
(167, 'Descrever a cultura local para enaltecer a prosperidade portuguesa.',0,34),
(168, 'Transmitir o conhecimento dos indígenas sobre o potencial econômico existente.',0,34),
(169, 'Realçar a pobreza dos habitantes nativos para demarcar a superioridade europeia.',0,34),
(170, 'Criticar o modo de vida dos povos autóctones para evidenciar a ausência de trabalho.',0,34),
(171, 'copiava o modelo haitiano de emancipação negra.',0,35),
(172, 'incentivava a conquista de alforrias por meio de ações judiciais.',0,35),
(173, 'optava pela via legalista de libertação.',1,35),
(174, 'priorizava a negociação em torno das indenizações aos senhores.',0,35),
(175, 'antecipava a libertação paternalista dos cativos.',0,35),
(176, 'fomentar ações públicas para ocupação das terras do interior.',0,36),
(177, 'adotar o regime assalariado para proteção da mão de obra estrangeira.',0,36),
(178, 'definir uma política de subsídio governamental para o fomento da imigração.',1,36),
(179, 'regulamentar o tráfico interprovincial de cativos para sobrevivência das fazendas.',0,36),
(180, 'financiar a fixação de famílias camponesas para estímulo da agricultura de subsistência.',0,36),
(181, 'redivisão do trabalho doméstico.',0,37),
(182, 'liberdade de orientação sexual.',0,37),
(183, 'garantia da equiparação salarial.',0,37),
(184, 'aprovação do direito ao divórcio.',0,37),
(185, 'obtenção da participação eleitoral.',1,37),
(186, 'extinção dos partidos nanicos.',0,38),
(187, 'retomada dos partidos estaduais.',0,38),
(188, 'adoção do bipartidarismo regulado.',1,38),
(189, 'superação do fisiologismo tradicional.',0,38),
(190, 'valorização da representação parlamentar.',0,38),
(191, '"Nasci para satisfazer a grande necessidade que eu tinha de mim mesmo." (Jean Paul Sartre)',0,39),
(192, '“Ter fé é assinar uma folha em branco e deixar que Deus nela escreva o que quiser." (Santo Agostinho)',1,39),
(193, '“Quem não tem medo da vida também não tem medo da morte.” (Arthur Schopenhauer)',0,39),
(194, '“Não me pergunte quem sou eu e não me diga para permanecer o mesmo.” (Michel Foucault)',0,39),
(195, '“O homem, em seu orgulho, criou a Deus a sua imagem e semelhança.” (Friedrich Nietzsche)',0,39),
(196, 'elaboração de um ordenamento político com fundamento na bondade infinita de Deus.',0,40),
(197, 'explicitação dos acontecimentos políticos do período clássico de forma imparcial.',0,40),
(198, 'utilização da oratória política como meio de convencer os oponentes na ágora.',0,40),
(199, 'investigação das constituições políticas de Atenas pelo método indutivo.',0,40),
(200, 'idealização de um mundo político perfeito existente no mundo das ideias.',1,40),
(201, 'compromisso com os movimentos desvinculados da legalidade.', 0,41),
(202, 'benefício para o maior número possível de indivíduos.', 0,41),
(203, 'interesse para a classe social do agente da ação.', 0,41),
(204, 'fundamento na categoria de progresso histórico.', 0,41),
(205, 'princípio de dar a cada um o que lhe é devido.', 1,41),
(206, 'coisas imagináveis, já que ele não tem controle sobre os acontecimentos da natureza.', 0,42),
(207, 'ações humanas, ciente da influência e da determinação dos astros sobre as mesmas.', 0,42),
(208, 'fatos atingíveis pela ação humana, desde que estejam sob seu controle.', 1,42),
(209, 'fatos e ações mutáveis da natureza, já que ele é parte dela.', 0,42),
(210, 'coisas eternas, já que ele é por essência um ser religioso.', 0,42),
(211, 'adoção da experiência do senso comum como critério de verdade.', 0,43),
(212, 'incapacidade de a razão confirmar o conhecimento resultante de evidências empíricas.', 0,43),
(213, 'pretensão de a experiência legitimar por si mesma a verdade.', 0,43),
(214, 'defesa de que a honestidade condiciona a possibilidade de se pensar a verdade.', 0,43),
(215, 'compreensão de que a verdade deve ser justificada racionalmente.', 1,43),
(216, 'excelência de atividades praticadas em consonância com o bem comum.',1,44),
(217, 'concretização utilitária de ações que revelam a manifestação de propósitos privados.',0,44),
(218, 'concordância das ações humanas aos preceitos emanados da divindade.',0,44),
(219, 'realização de ações que permitem a configuração da paz interior.',0,44),
(220, 'emanifestação de ações estéticas, coroadas de adorno e beleza.',0,44),
(221, 'atuação como provedora do lar.',0,45),
(222, 'inserção no mercado de trabalho.',0,45),
(223, 'inserção no mercado de trabalho.',0,45),
(224, 'proteção contra ações de violência.',1,45),
(225, 'participação enquanto gestora pública.',0,45);