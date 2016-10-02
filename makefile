SOURCE_PARSE_DIR=src/main/java/parse/
BUILD_PARSE_DIR=build/main/classes/parse/

all: $(BUILD_PARSE_DIR)ArticleParse.class

clean:
	rm $(BUILD_PARSE_DIR)/*

$(BUILD_PARSE_DIR)ArticleParse.class : $(SOURCE_PARSE_DIR)/ArticleParse.java 
	javac -d $(BUILD_PARSE_DIR) $(SOURCE_PARSE_DIR)/ArticleParse.java 