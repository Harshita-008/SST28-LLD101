public class ClassroomController {
    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) { this.reg = reg; }

    public void startClass() {
        IInputConnector pj = reg.getFirstOfType(IInputConnector.class);
        IPowerSwitch power = (IPowerSwitch) pj;
        power.powerOn();
        pj.connectInput("HDMI-1");

        IBrightnessControl lights = reg.getFirstOfType(IBrightnessControl.class);
        lights.setBrightness(60);

        ITemperatureControl ac = reg.getFirstOfType(ITemperatureControl.class);
        ac.setTemperatureC(24);

        IAttendanceProvider scan = reg.getFirstOfType(IAttendanceProvider.class);
        System.out.println("Attendance scanned: present=" + scan.scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        reg.getFirstOfType(Projector.class).powerOff();
        reg.getFirstOfType(LightsPanel.class).powerOff();
        reg.getFirstOfType(AirConditioner.class).powerOff();
    }
}
