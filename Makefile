# Define the Java compiler to use
JC = javac

# Define the source and class directories
SRCDIR = src
BINDIR = bin

# Define the list of Java source files to compile
SOURCES := $(SRCDIR)/Backend/MathHelper.java $(SRCDIR)/TCP/TCPClient.java $(SRCDIR)/TCP/TCPServer.java

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
	@mkdir -p $(@D)
	$(JC) $(JFLAGS) $<

# Run the TCPServer and two TCPClient instances
# Sleep for 2 seconds after launching server to wait for server socket to be opened
run:
	java -cp $(BINDIR) TCP.TCPServer &
	sleep 2
	java -cp $(BINDIR) TCP.TCPClient &
	java -cp $(BINDIR) TCP.TCPClient &

