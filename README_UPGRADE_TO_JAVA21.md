Upgrade para Java 21 - instruções

Resumo
------
Este repositório foi preparado para compilar com Java 21 (propriedade `java.version` e `maven-compiler-plugin` atualizados). O código foi alterado e commitado na branch `upgrade/java21`, mas o build local falhou porque o JDK 21 não está instalado no sistema.

O que foi feito
--------------
- `pom.xml`: atualizado `java.version` para `21` e adicionado `maven-compiler-plugin` com `<release>21`.
- `WebConfig.java`: correção do package para coincidir com a hierarquia de pastas.
- Branch criada: `upgrade/java21` e commit realizado com as mudanças.

Passos necessários (Windows - PowerShell)
----------------------------------------
1) Instalar JDK 21 (Adoptium / Oracle / Eclipse Temurin). Exemplo usando Adoptium (manual):
   - Baixe o instalador do JDK 21 em https://adoptium.net/ ou https://jdk.java.net/21/
   - Execute o instalador e anote o caminho de instalação (ex.: C:\Program Files\Java\jdk-21)

2) Ajustar variáveis de ambiente (PowerShell):

```powershell
# Substitua o caminho abaixo pelo caminho do JDK 21 instalado
$jdkPath = 'C:\Program Files\Java\jdk-21'
[Environment]::SetEnvironmentVariable('JAVA_HOME', $jdkPath, 'User')
$env:JAVA_HOME = $jdkPath
# Adicione javac/java no PATH (opcional se instalador já fez)
$oldPath = [Environment]::GetEnvironmentVariable('Path', 'User')
if (-not $oldPath.Contains("$jdkPath\\bin")) {
    [Environment]::SetEnvironmentVariable('Path', "$jdkPath\\bin;" + $oldPath, 'User')
    $env:Path = "$jdkPath\\bin;" + $env:Path
}

# Verificar
java -version
javac -version
```

3) Rodar build Maven (na raiz do projeto):

```powershell
cd C:\Users\lulal\Downloads\PetExpress_Site
.\mvnw.cmd -DskipTests package
```

Se tudo ocorrer bem, o build deve completar com `BUILD SUCCESS`.

Observações e próximos passos
---------------------------
- Se quiser, posso tentar criar um Pull Request (push) para o repositório remoto — confirme se quer que eu faça o push agora.
- Também posso externalizar a configuração de CORS para `application.properties` e/ou adicionar testes de compilação automatizados.

Se quiser que eu continue (por exemplo, fazer o push para o remoto ou ajustar outras configurações), diga "push" ou detalhe o próximo passo desejado.
