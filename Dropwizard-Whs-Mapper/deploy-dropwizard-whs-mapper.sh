lsof -t -i :8080 | while read line
do
	kill -9 $line
done

java -jar target/DropWizard-Whs-Mapper-0.0.1-SNAPSHOT.jar server src/main/resources/whs-mapper.yml
