# IMC
Atividade com o objetivo de melhorar  o app de IMC

Isaac Ferreira dos Santos RA: 23025417

Kauê Dantas RA: 23025287

Ícaro Dellalo RA: 23025413

Giovanne Braga RA: 23025648

**O repositório da primeira versão da aplicação se encontra na branch master**

**O repositório da segunda versão da aplicação se encontra na branch versao2**


# Alterações realizadas primeira versão:

Inclusão da classificação do IMC;

Inclusão da classificação do IMC por sexo;

Validação de campos não preenchidos;

Atualização do placeholder;

Inclusão da função para limpar.

# Como foi feito:

**Validação de campos não preenchidos**

Utilização do if/else para garantir que os campos foram preenchidos;

Utilização do if/else para classificação do IMC e a propriedade "equals" para filtrar se é masculino ou feminino;

Método para limpar os dados, foi utilizado strings vazias para preencher os campos que estão preenchidos com dados, para as seleções de radio de sexo, foi utilizado o "clearCheck", também foi utilizado o "RadioGroup" para garantir seleção única.

O placeholder foi alterado por meio dos atributos, foi atualizado, para alertar o usuário acerca das entradas corretas dos dados



# Alterações realizadas segunda versão:

Inclusão de novas activites para cada classificação do IMC;

Inclusão de informações adicionais para cada tipo de IMC;

Criação do botão close para cada Activity;

Abertura da Activity.


# Como foi feito:

**Abertura de Activity**

Adição do intent para abertura de uma activity com a classificação:

Intent intent;
            if (classificacao.equals("Abaixo do peso")) {
                intent = new Intent(this, AbaixodoPeso.class);
                  startActivity(intent);

**Fechar a Activity**

Foi utilizado um método na Activity "finish()":
 public void fecharJanela(View view) {
        finish();}





