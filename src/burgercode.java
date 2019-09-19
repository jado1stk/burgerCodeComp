/* Generated By:JavaCC: Do not edit this line. burgercode.java */
public class burgercode implements burgercodeConstants {
  public static void main(String args []) throws ParseException
  {
    burgercode parser = new burgercode(System.in);
    while (true)
    {
      System.out.println("O que vai ser hoje?:\u005cn");

      try
      {
        parser.principal();
      }
      catch (Exception e)
      {
        System.out.println("Me desculpa. Isso nunca aconteceu antes.");
        System.out.println(e.getMessage());
        burgercode.ReInit(System.in);
        break;
      }
      catch (Error e)
      {
        System.out.println("Opa.");
        System.out.println(e.getMessage());
        break;
      }
    }
  }

  static final public void principal() throws ParseException {
    jj_consume_token(INICIOPROGRAMA);
    jj_consume_token(ABREPAR);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case REAL:
      case INTEIRO:
      case LETRA:
      case IDENTIFICADOR:
      case IF:
      case FOR:
      case DO:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      bloco();
    }
    jj_consume_token(FECHAPAR);
  }

  static final public void bloco() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case REAL:
    case INTEIRO:
    case LETRA:
      declaracaoVariavel();
      break;
    case IDENTIFICADOR:
      expressao();
      break;
    case IF:
      condicionalSe();
      break;
    case FOR:
      repeticaoFor();
      break;
    case DO:
      repeticaoDo();
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void declaracaoVariavel() throws ParseException {
    tipoDado();
    atribuiVariavel();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VIRGULA:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      jj_consume_token(VIRGULA);
      atribuiVariavel();
    }
    jj_consume_token(FIMINSTRUCAO);
  }

  static final public void atribuiVariavel() throws ParseException {
    jj_consume_token(IDENTIFICADOR);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ATRIBUICAO:
      jj_consume_token(ATRIBUICAO);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CARACTERE:
        jj_consume_token(CARACTERE);
        break;
      case NUMERO:
        jj_consume_token(NUMERO);
        break;
      default:
        jj_la1[3] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[4] = jj_gen;
      ;
    }
  }

  static final public void tipoDado() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case REAL:
      jj_consume_token(REAL);
      break;
    case INTEIRO:
      jj_consume_token(INTEIRO);
      break;
    case LETRA:
      jj_consume_token(LETRA);
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void printarVariavel() throws ParseException {
        Token t;
    t = jj_consume_token(IDENTIFICADOR);
                           System.out.println("Este e o " + t.image);
  }

  static final public void condicionalSe() throws ParseException {
    jj_consume_token(IF);
    jj_consume_token(ABRECHAVE);
    condicao();
    jj_consume_token(FECHACHAVE);
    jj_consume_token(ABREPAR);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case REAL:
      case INTEIRO:
      case LETRA:
      case IDENTIFICADOR:
      case IF:
      case FOR:
      case DO:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_3;
      }
      bloco();
    }
    jj_consume_token(FECHAPAR);
  }

  static final public void condicao() throws ParseException {
    conta();
    comparacao();
    conta();
  }

  static final public void comparacao() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NEGACAO:
      jj_consume_token(NEGACAO);
      break;
    case IGUALIGUAL:
      jj_consume_token(IGUALIGUAL);
      break;
    case IGUAL:
      jj_consume_token(IGUAL);
      break;
    case IGUALMAIOR:
      jj_consume_token(IGUALMAIOR);
      break;
    case MAIOR:
      jj_consume_token(MAIOR);
      break;
    case IGUALMENOR:
      jj_consume_token(IGUALMENOR);
      break;
    case MENOR:
      jj_consume_token(MENOR);
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void expressao() throws ParseException {
    jj_consume_token(IDENTIFICADOR);
    jj_consume_token(ATRIBUICAO);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CARACTERE:
      label_4:
      while (true) {
        jj_consume_token(CARACTERE);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case CARACTERE:
          ;
          break;
        default:
          jj_la1[8] = jj_gen;
          break label_4;
        }
      }
      break;
    case DIGITO:
    case NUMERO:
    case IDENTIFICADOR:
    case ABRECHAVE:
      conta();
      break;
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(FIMINSTRUCAO);
  }

  static final public void conta() throws ParseException {
    valores();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SOMA:
      case SUBTRACAO:
      case MULTIPLICACAO:
      case DIVISAO:
        ;
        break;
      default:
        jj_la1[10] = jj_gen;
        break label_5;
      }
      operacao();
      valores();
    }
  }

  static final public void contaComPrescendencia() throws ParseException {
    jj_consume_token(ABRECHAVE);
    conta();
    jj_consume_token(FECHACHAVE);
  }

  static final public void valores() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFICADOR:
      jj_consume_token(IDENTIFICADOR);
      break;
    case DIGITO:
      jj_consume_token(DIGITO);
      break;
    case NUMERO:
      jj_consume_token(NUMERO);
      break;
    case ABRECHAVE:
      contaComPrescendencia();
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void operacao() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SOMA:
      jj_consume_token(SOMA);
      break;
    case SUBTRACAO:
      jj_consume_token(SUBTRACAO);
      break;
    case MULTIPLICACAO:
      jj_consume_token(MULTIPLICACAO);
      break;
    case DIVISAO:
      jj_consume_token(DIVISAO);
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void repeticaoFor() throws ParseException {
    jj_consume_token(FOR);
    jj_consume_token(ABRECHAVE);
    label_6:
    while (true) {
      jj_consume_token(IDENTIFICADOR);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFICADOR:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_6;
      }
    }
    jj_consume_token(IGUAL);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DIGITO:
      jj_consume_token(DIGITO);
      break;
    case NUMERO:
      jj_consume_token(NUMERO);
      break;
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(PARA);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DIGITO:
      jj_consume_token(DIGITO);
      break;
    case NUMERO:
      jj_consume_token(NUMERO);
      break;
    default:
      jj_la1[15] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(FECHACHAVE);
    jj_consume_token(ABREPAR);
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case REAL:
      case INTEIRO:
      case LETRA:
      case IDENTIFICADOR:
      case IF:
      case FOR:
      case DO:
        ;
        break;
      default:
        jj_la1[16] = jj_gen;
        break label_7;
      }
      bloco();
    }
    jj_consume_token(FECHAPAR);
  }

  static final public void repeticaoDo() throws ParseException {
    jj_consume_token(DO);
    jj_consume_token(ABREPAR);
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case REAL:
      case INTEIRO:
      case LETRA:
      case IDENTIFICADOR:
      case IF:
      case FOR:
      case DO:
        ;
        break;
      default:
        jj_la1[17] = jj_gen;
        break label_8;
      }
      bloco();
    }
    jj_consume_token(FECHAPAR);
    jj_consume_token(WHILE);
    jj_consume_token(ABRECHAVE);
    condicao();
    jj_consume_token(FECHACHAVE);
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public burgercodeTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[18];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x350700,0x350700,0x2000,0xc000,0x20000,0x700,0x350700,0x0,0x8000,0x2001d000,0x1e000000,0x20015000,0x1e000000,0x10000,0x5000,0x5000,0x350700,0x350700,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0xfe,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,};
   }

  /** Constructor with InputStream. */
  public burgercode(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public burgercode(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new burgercodeTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public burgercode(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new burgercodeTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public burgercode(burgercodeTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(burgercodeTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 18; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[40];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 18; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 40; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
