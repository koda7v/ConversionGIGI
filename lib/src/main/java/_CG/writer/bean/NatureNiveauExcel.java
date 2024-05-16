package _CG.writer.bean;

public enum NatureNiveauExcel {
	CO, CUE, S, SO, SUE, TS, TSO, TSUE;

	public String value() {
		return name();
	}

	public static NatureNiveauExcel fromValue(String v) {
		return valueOf(v);
	}
}
