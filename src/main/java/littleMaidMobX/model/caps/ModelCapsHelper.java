package littleMaidMobX.model.caps;

import littleMaidMobX.util.helper.CastHelper;


public class ModelCapsHelper {

	public static Object getCapsValue(IModelCaps pOwner, int pCapsIndex, Object ...pArg) {
		return pOwner == null ? null : pOwner.getCapsValue(pCapsIndex, pArg);
	}

	public static Object getCapsValue(IModelCaps pOwner, String pCapsName, Object ...pArg) {
		return pOwner == null ? null : pOwner.getCapsValue(pOwner.getModelCaps().get(pCapsName), pArg);
	}

	public static int getCapsValueInt(IModelCaps pOwner, int pIndex, Object ...pArg) {
		if (pOwner == null) return 0;
		Integer li = (Integer)pOwner.getCapsValue(pIndex, pArg);
		return li == null ? 0 : li;
	}

	public static float getCapsValueFloat(IModelCaps pOwner, int pIndex, Object ...pArg) {
		if (pOwner == null) return 0F;
		Float lf = (Float)pOwner.getCapsValue(pIndex, pArg);
		return lf == null ? 0F : lf;
	}

	public static double getCapsValueDouble(IModelCaps pOwner, int pIndex, Object ...pArg) {
		if (pOwner == null) return 0D;
		Double ld = (Double)pOwner.getCapsValue(pIndex, pArg);
		return ld == null ? 0D : ld;
	}

	public static boolean getCapsValueBoolean(IModelCaps pOwner, int pIndex, Object ...pArg) {
		if (pOwner == null) return false;
		Boolean lb = (Boolean)pOwner.getCapsValue(pIndex, pArg);
		return lb == null ? false : lb;
	}

	public static boolean setCapsValue(IModelCaps pOwner, String pCapsName, Object... pArg) {
		return pOwner == null ? false : pOwner.setCapsValue(pOwner.getModelCaps().get(pCapsName), pArg);
	}

	public static Object getCapsValue(Object model, Object entityCaps, int pIndex, Object ...pArg) {
		Object o = entityCaps == null ? null : getCapsValueCaps(entityCaps, pIndex, pArg);
		if (o != null) return o;
		return getCapsValueModel(model, entityCaps, pIndex, pArg);
	}

	public static Object getCapsValue(Object model, IModelCaps entityCaps, int pIndex, Object ...pArg) {
		Object o = entityCaps == null ? null : entityCaps.getCapsValue(pIndex, pArg);
		if (o != null) return o;
		return getCapsValueModel(model, entityCaps, pIndex, pArg);
	}

	public static Object getCapsValue(Object entityCaps, int pIndex, Object ...pArg) {
		return getCapsValueCaps(entityCaps, pIndex, pArg);
	}


	public static int getCapsValueInt(Object model, Object entityCaps, int pIndex, Object ...pArg) {
		return CastHelper.Int(getCapsValue(model, entityCaps, pIndex, pArg), 0, 2, 1);
	}

	public static int getCapsValueInt(Object model, IModelCaps entityCaps, int pIndex, Object ...pArg) {
		Object a = getCapsValue(model, entityCaps, pIndex, pArg);
		return CastHelper.Int(a, 0, 2, 1);
	}

	public static long getCapsValueLong(Object model, Object entityCaps, int pIndex, Object ...pArg) {
		return CastHelper.Long(getCapsValue(model, entityCaps, pIndex, pArg));
	}

	public static long getCapsValueLong(Object model, IModelCaps entityCaps, int pIndex, Object ...pArg) {
		return CastHelper.Long(getCapsValue(model, entityCaps, pIndex, pArg));
	}

	public static byte getCapsValueByte(Object model, Object entityCaps, int pIndex, Object ...pArg) {
		return CastHelper.Byte(getCapsValue(model, entityCaps, pIndex, pArg), (byte) 0, (byte) 2, (byte) 1);
	}

	public static byte getCapsValueByte(Object model, IModelCaps entityCaps, int pIndex, Object ...pArg) {
		return CastHelper.Byte(getCapsValue(model, entityCaps, pIndex, pArg), (byte) 0, (byte) 2, (byte) 1);
	}

	public static float getCapsValueFloat(Object model, Object entityCaps, int pIndex, Object ...pArg) {
		return CastHelper.Float(getCapsValue(model, entityCaps, pIndex, pArg));
	}

	public static float getCapsValueFloat(Object model, IModelCaps entityCaps, int pIndex, Object ...pArg) {
		return CastHelper.Float(getCapsValue(model, entityCaps, pIndex, pArg));
	}

	public static double getCapsValueDouble(Object model, Object entityCaps, int pIndex, Object ...pArg) {
		return CastHelper.Double(getCapsValue(model, entityCaps, pIndex, pArg));
	}

	public static double getCapsValueDouble(Object model, IModelCaps entityCaps, int pIndex, Object ...pArg) {
		return CastHelper.Double(getCapsValue(model, entityCaps, pIndex, pArg));
	}

	public static boolean getCapsValueBoolean(Object model, Object entityCaps, int pIndex, Object ...pArg) {
		return CastHelper.Boolean(getCapsValue(model, entityCaps, pIndex, pArg));
	}

	public static boolean getCapsValueBoolean(Object model, IModelCaps entityCaps, int pIndex, Object ...pArg) {
		return CastHelper.Boolean(getCapsValue(model, entityCaps, pIndex, pArg));
	}

	public static boolean getCapsValueBoolean(Object entityCaps, int pIndex, Object ...pArg) {
		return CastHelper.Boolean(getCapsValueCaps(entityCaps, pIndex, pArg));
	}

	private static Object getCapsValueCaps(Object entityCaps, int pIndex, Object ...pArg) {
		return entityCaps instanceof IModelCaps ? ((IModelCaps)entityCaps).getCapsValue(pIndex, pArg) : null;
	}

	private static Object getCapsValueModel(Object model, Object entityCaps, int pIndex, Object ...pArg) {
		if (model == null) {
			String s = "Modchu_ModelCapsHelper getCapsValueModel model == null !!";
			throw new NullPointerException(s);
		}
		return (!(model instanceof IModelCaps))? null : ((IModelCaps)model).getCapsValue(pIndex, pArg);
	}

}
