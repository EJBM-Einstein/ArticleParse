SOURCE_DIR=src/main/java/
BUILD_DIR=build/main/classes/

EJBM_SOURCE_DIR=$(SOURCE_DIR)ejbm/
EJBM_BUILD_DIR=$(BUILD_DIR)ejbm/

PARSER_SOURCE_DIR=$(EJBM_SOURCE_DIR)parser/
PARSER_BUILD_DIR=$(EJBM_BUILD_DIR)parser/

CLASS_PATH=.:$(BUILD_DIR):libs/pdfbox-2.0.3.jar

SOURCES= \
	$(EJBM_SOURCE_DIR)ArticleParse.java \
	$(PARSER_SOURCE_DIR)Parser.java \
	$(PARSER_SOURCE_DIR)ParserConfiguration.java \
	$(PARSER_SOURCE_DIR)ParserFileVisitor.java \


CLASSES= \
	$(EJBM_BUILD_DIR)ArticleParse.class \
	$(PARSER_BUILD_DIR)Parser.class \
	$(PARSER_BUILD_DIR)ParserConfiguration.class \
	$(PARSER_BUILD_DIR)ParserFileVisitor.class \



all: $(CLASSES)

clean:
	rm -f $(CLASSES)


$(EJBM_BUILD_DIR)%.class : $(EJBM_SOURCE_DIR)%.java
	javac -cp "$(CLASS_PATH)" -d $(BUILD_DIR) $(SOURCES)

$(PARSER_BUILD_DIR)%.class : $(PARSER_SOURCE_DIR)%.java 
	javac -cp "$(CLASS_PATH)" -d $(BUILD_DIR) $(SOURCES)