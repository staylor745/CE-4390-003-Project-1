# Define the Java compiler to use
JC = javac

# Define the source and class directories
SRCDIR = src
BINDIR = out/production/CE-4390-003-Project-1

# Define the list of Java source files to compile
SOURCES := $(wildcard $(SRCDIR)/**/*.java)

# Define the class files to generate
CLASSES := $(SOURCES:$(SRCDIR)/%.java=$(BINDIR)/%.class)

# Set the Java compiler options
JFLAGS = -source 1.8 -target 1.8 -d $(BINDIR) -cp $(BINDIR)

# Define the default Make target
default: classes run

# Compile Java source files
classes: $(CLASSES)

# Add a dependency on the source files to ensure that they are recompiled when modified
$(CLASSES): $(SOURCES)

$(BINDIR)/%.class: $(SRCDIR)/%.java
	$(JC) $(JFLAGS) $<

# Run the TCPServer and two TCPClient instances
run:
	java -cp $(BINDIR) TCP.TCPServer &
	java -cp $(BINDIR) TCP.TCPClient &
	java -cp $(BINDIR) TCP.TCPClient &
