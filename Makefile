ALL:
	java CalhipoMain

compile:
	javac *.java

clean:
	rm *.class

save:
	git add *.java
