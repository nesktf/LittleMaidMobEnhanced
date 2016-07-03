package littleMaidMobX.model.maid;



public class ModelLittleMaid_Orign extends ModelLittleMaidBase {

	public ModelLittleMaid_Orign(StringBuilder hack) {
		super(hack);
	}
	
	public ModelLittleMaid_Orign() {
		super();
	}
	
	public ModelLittleMaid_Orign(float psize) {
		super(psize);
	}
	
	public ModelLittleMaid_Orign(float psize, float pyoffset, int pTextureWidth, int pTextureHeight) {
		super(psize, pyoffset, pTextureWidth, pTextureHeight);
	}


	@Override
	public String getUsingTexture() {
		return "default";
	}

}
