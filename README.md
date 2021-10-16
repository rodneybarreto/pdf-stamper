## PDF-Stamper
### Insere estampa de assinatura em documentos para impressão.

### Java 8

#### Comando de Build
```
mvn clean compile assembly:single
```
#### Procedimento após a geração do ".jar"
```
mv pdf-stamper-1.0.0-jar-with-dependencies.jar pdf-stamper.jar
```
#### Exemplo de execução
```
$ java -cp pdf-stamper.jar \ 
br.dev.rodneybarreto.stamper.App \ 
nome-arquivo-entrada.pdf \
nome-arquivo-saida.pdf \
"Texto da primeira linha" \
"Texto da segunda linha"
```