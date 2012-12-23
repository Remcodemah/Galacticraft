package micdoodle8.mods.galacticraft.core.client.sounds;

import micdoodle8.mods.galacticraft.core.entities.GCCoreEntitySpaceship;
import net.minecraft.client.audio.SoundManager;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.relauncher.Side;

@SideOnly(Side.CLIENT)
public class GCCoreSoundUpdaterSpaceship implements IUpdatePlayerListBox
{
    private final SoundManager field_82477_a;
    private final GCCoreEntitySpaceship field_82475_b;
    private final EntityPlayerSP field_82476_c;
    private boolean field_82473_d = false;
    private boolean field_82474_e = false;
    private boolean field_82471_f = false;
    private boolean field_82472_g = false;
    private float field_82480_h = 0.0F;
    private float field_82481_i = 0.0F;
    private float field_82478_j = 0.0F;
    private double field_82479_k = 0.0D;

    public GCCoreSoundUpdaterSpaceship(SoundManager par1SoundManager, GCCoreEntitySpaceship par2EntityMinecart, EntityPlayerSP par3EntityPlayerSP)
    {
        this.field_82477_a = par1SoundManager;
        this.field_82475_b = par2EntityMinecart;
        this.field_82476_c = par3EntityPlayerSP;
    }

    /**
     * Updates the JList with a new model.
     */
    @Override
	public void update()
    {
        boolean var1 = false;
        final boolean var2 = this.field_82473_d;
        final boolean var3 = this.field_82474_e;
        final boolean var4 = this.field_82471_f;
        final float var5 = this.field_82481_i;
        final float var6 = this.field_82480_h;
        final float var7 = this.field_82478_j;
        final double var8 = this.field_82479_k;
        this.field_82473_d = this.field_82476_c != null && this.field_82475_b.riddenByEntity == this.field_82476_c;
        this.field_82474_e = this.field_82475_b.isDead;
        this.field_82479_k = 20;
        this.field_82471_f = this.field_82479_k >= 0.01D;

        if (var2 && !this.field_82473_d)
        {
            this.field_82477_a.stopEntitySound(this.field_82476_c);
        }

        if (this.field_82474_e || !this.field_82472_g && this.field_82481_i == 0.0F && this.field_82478_j == 0.0F)
        {
            if (!var3)
            {
                this.field_82477_a.stopEntitySound(this.field_82475_b);

                if (var2 || this.field_82473_d)
                {
                    this.field_82477_a.stopEntitySound(this.field_82476_c);
                }
            }

            this.field_82472_g = true;

            if (this.field_82474_e)
            {
                return;
            }
        }

        if (this.field_82477_a != null && this.field_82475_b != null && this.field_82475_b.getReversed() == 0 && this.field_82481_i > 0.0F)
        {
            this.field_82477_a.playEntitySound("shuttle.sound", this.field_82475_b, this.field_82481_i, this.field_82480_h, false);
            this.field_82472_g = false;
            var1 = true;
        }
        else if (this.field_82477_a != null && this.field_82475_b != null && this.field_82475_b.getReversed() == 1 && this.field_82481_i > 0.0F)
        {
            this.field_82477_a.playEntitySound("shuttle.sound", this.field_82475_b, this.field_82481_i, 1.0F, false);
            this.field_82472_g = false;
            var1 = true;
        }

//        if (this.field_82473_d && !this.field_82477_a.func_82465_b(this.field_82476_c) && this.field_82478_j > 0.0F)
//        {
//            this.field_82477_a.func_82467_a("shuttle.sound", this.field_82476_c, this.field_82478_j, 1.0F, true);
//            this.field_82472_g = false;
//            var1 = true;
//        }
        
        if (this.field_82475_b.getTimeUntilLaunch() <= 400)
        {
        	if (this.field_82475_b.getTimeUntilLaunch() < 400)
        	{
                if (this.field_82480_h < 1.0F)
                {
                    this.field_82480_h += 0.0025F;
                }

                if (this.field_82480_h > 1.0F)
                {
                    this.field_82480_h = 1.0F;
                }
        	}

            float var10 = MathHelper.clamp_float((float)this.field_82479_k, 0.0F, 4.0F) / 4.0F;
            this.field_82478_j = 0.0F + var10 * 0.75F;
            var10 = MathHelper.clamp_float(var10 * 2.0F, 0.0F, 1.0F);
            this.field_82481_i = 0.0F + var10 * 0.7F;
        }
        else if (var4)
        {
            this.field_82481_i = 0.0F;
            this.field_82480_h = 0.0F;
            this.field_82478_j = 0.0F;
        }

        if (!this.field_82472_g)
        {
            if (this.field_82480_h != var6)
            {
                this.field_82477_a.setEntitySoundPitch(this.field_82475_b, this.field_82480_h);
            }

            if (this.field_82481_i != var5)
            {
                this.field_82477_a.setEntitySoundVolume(this.field_82475_b, this.field_82481_i);
            }

            if (this.field_82478_j != var7)
            {
                this.field_82477_a.setEntitySoundVolume(this.field_82476_c, this.field_82478_j);
            }
        }

        if (!var1)
        {
            this.field_82477_a.updateSoundLocation(this.field_82475_b);

            if (this.field_82473_d)
            {
                this.field_82477_a.updateSoundLocation(this.field_82476_c, this.field_82475_b);
            }
        }
    }
}
