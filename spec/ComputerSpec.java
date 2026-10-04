package spec;

public record ComputerSpec(String cpu, int ramGb, int storageGb, String operatingSystem) {

    public ComputerSpec {
        if (cpu == null || cpu.isBlank()) {
            throw new IllegalArgumentException("CPU must not be empty");
        }
        if (ramGb <= 0 || storageGb <= 0) {
            throw new IllegalArgumentException("RAM and storage must be positive");
        }
        if (operatingSystem == null || operatingSystem.isBlank()) {
            throw new IllegalArgumentException("Operating system must not be empty");
        }
    }
}
